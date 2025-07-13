import core.scheduler.VaccineScheduler;
import models.Beneficiary;

public class Main {
    public static void main(String[] args) {
        // Initialize system
        VaccineScheduler scheduler = new VaccineScheduler();
        
        // Register a beneficiary
        Beneficiary mother = new Beneficiary("B001", "Priya Sharma", 28, "VillageA");
        System.out.println("Registered: " + mother.getName());
        
        // Schedule a vaccine
        scheduler.scheduleVaccine(mother.getId(), "BCG", "2023-12-15");
        System.out.println("Next vaccine due: " + scheduler.getNextDue());
    }
}