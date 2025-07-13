package core.scheduler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VaccineReminder {
    private String beneficiaryId;
    private String vaccineName;
    private LocalDate dueDate;
    private boolean completed;
    private int doseNumber;
    
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String[] VACCINE_SCHEDULE = {
        "BCG,0", 
        "OPV-1,6", 
        "OPV-2,10", 
        "DPT-1,6", 
        "DPT-2,10", 
        "Measles,9"
    };

    public VaccineReminder(String beneficiaryId, String vaccineName, String dueDate) {
        this.beneficiaryId = beneficiaryId;
        this.vaccineName = vaccineName;
        this.dueDate = LocalDate.parse(dueDate, DATE_FORMAT);
        this.completed = false;
        this.doseNumber = getDoseNumber(vaccineName);
    }

    private int getDoseNumber(String vaccineName) {
        for (String entry : VACCINE_SCHEDULE) {
            String[] parts = entry.split(",");
            if (parts[0].equals(vaccineName)) {
                return Integer.parseInt(parts[1]);
            }
        }
        return 0;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && !completed;
    }

    // Getters and toString()
    public String getBeneficiaryId() { return beneficiaryId; }
    public String getVaccineName() { return vaccineName; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }
    public int getDoseNumber() { return doseNumber; }

    @Override
    public String toString() {
        return String.format("%s (Dose %d) for %s due %s%s", 
            vaccineName, doseNumber, beneficiaryId, 
            dueDate.format(DATE_FORMAT),
            isOverdue() ? " - OVERDUE!" : "");
    }
}