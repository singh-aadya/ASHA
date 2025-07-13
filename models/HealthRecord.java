package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HealthRecord {
    private String recordId;
    private String beneficiaryId;
    private LocalDate date;
    private double weightKg;
    private double heightCm;
    private double temperatureC;
    private String observations;
    
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public HealthRecord(String recordId, String beneficiaryId, String date, 
                      double weightKg, double heightCm, double temperatureC, 
                      String observations) {
        this.recordId = recordId;
        this.beneficiaryId = beneficiaryId;
        this.date = LocalDate.parse(date, DATE_FORMAT);
        this.weightKg = weightKg;
        this.heightCm = heightCm;
        this.temperatureC = temperatureC;
        this.observations = observations;
    }

    public boolean hasFever() {
        return temperatureC > 37.5;
    }

    public String getNutritionStatus(boolean isMale) {
        int ageMonths = (int) java.time.temporal.ChronoUnit.MONTHS.between(
            date, LocalDate.now());
        return WHOTables.assess(weightKg, ageMonths, isMale).toString();
    }

    // Getters
    public String getRecordId() { return recordId; }
    public String getBeneficiaryId() { return beneficiaryId; }
    public String getDate() { return date.format(DATE_FORMAT); }
    public double getWeightKg() { return weightKg; }
    public double getHeightCm() { return heightCm; }
    public double getTemperatureC() { return temperatureC; }
    public String getObservations() { return observations; }
}