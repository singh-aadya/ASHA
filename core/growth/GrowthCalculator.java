package core.growth;

public class GrowthCalculator {
    public static String assessNutrition(double weightKg, double heightCm, int ageMonths) {
        double expectedWeight = 2.5 + (0.5 * ageMonths); // Simplified formula
        if (weightKg < 0.8 * expectedWeight) {
            return "Malnourished";
        } else if (weightKg > 1.2 * expectedWeight) {
            return "Overweight";
        }
        return "Normal";
    }
}   