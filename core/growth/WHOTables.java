package core.growth;

import java.util.HashMap;
import java.util.Map;

public class WHOTables {
    private static final Map<Integer, double[]> GIRL_WEIGHT_STD = new HashMap<>();
    private static final Map<Integer, double[]> BOY_WEIGHT_STD = new HashMap<>();
    
    static {
        // Weight-for-age standards (3rd, 15th, 50th, 85th, 97th percentiles)
        GIRL_WEIGHT_STD.put(0, new double[]{2.4, 2.8, 3.2, 3.7, 4.2});
        GIRL_WEIGHT_STD.put(6, new double[]{5.7, 6.3, 7.3, 8.3, 9.3});
        GIRL_WEIGHT_STD.put(12, new double[]{7.0, 7.9, 9.0, 10.2, 11.5});
        
        BOY_WEIGHT_STD.put(0, new double[]{2.5, 2.9, 3.3, 3.9, 4.4});
        BOY_WEIGHT_STD.put(6, new double[]{6.0, 6.7, 7.9, 9.0, 10.2});
        BOY_WEIGHT_STD.put(12, new double[]{7.4, 8.3, 9.6, 10.9, 12.1});
    }

    public static GrowthAssessment assess(double weightKg, int ageMonths, boolean isMale) {
        Map<Integer, double[]> table = isMale ? BOY_WEIGHT_STD : GIRL_WEIGHT_STD;
        int nearestAge = findNearestAge(ageMonths, table.keySet());
        double[] percentiles = table.get(nearestAge);
        
        if (weightKg < percentiles[0]) return GrowthAssessment.SEVERE_UNDERWEIGHT;
        if (weightKg < percentiles[1]) return GrowthAssessment.UNDERWEIGHT;
        if (weightKg > percentiles[4]) return GrowthAssessment.OVERWEIGHT;
        if (weightKg > percentiles[3]) return GrowthAssessment.RISK_OF_OVERWEIGHT;
        return GrowthAssessment.NORMAL;
    }

    private static int findNearestAge(int ageMonths, Set<Integer> ageKeys) {
        int nearest = 0;
        for (int key : ageKeys) {
            if (Math.abs(key - ageMonths) < Math.abs(nearest - ageMonths)) {
                nearest = key;
            }
        }
        return nearest;
    }

    public enum GrowthAssessment {
        SEVERE_UNDERWEIGHT, UNDERWEIGHT, NORMAL, RISK_OF_OVERWEIGHT, OVERWEIGHT
    }
}