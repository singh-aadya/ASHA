package core.scheduler;

import java.util.PriorityQueue;

public class VaccineScheduler {
    private PriorityQueue<VaccineReminder> queue = 
        new PriorityQueue<>((a,b) -> a.dueDate.compareTo(b.dueDate));
    
    public void scheduleVaccine(String beneficiaryId, String vaccineName, String dueDate) {
        queue.add(new VaccineReminder(beneficiaryId, vaccineName, dueDate));
    }
    
    public String getNextDue() {
        return queue.peek().toString();
    }
    
    static class VaccineReminder {
        String beneficiaryId;
        String vaccineName;
        String dueDate;
        
        public VaccineReminder(String beneficiaryId, String vaccineName, String dueDate) {
            this.beneficiaryId = beneficiaryId;
            this.vaccineName = vaccineName;
            this.dueDate = dueDate;
        }
        
        @Override
        public String toString() {
            return vaccineName + " for " + beneficiaryId + " on " + dueDate;
        }
    }
}