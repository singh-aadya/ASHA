package core.routing;

import java.util.*;

public class VillageRouter {
    private Map<String, Map<String, Integer>> routes = new HashMap<>();
    
    public void addRoute(String village1, String village2, int distance) {
        routes.computeIfAbsent(village1, k -> new HashMap<>()).put(village2, distance);
        routes.computeIfAbsent(village2, k -> new HashMap<>()).put(village1, distance);
    }
    
    public List<String> optimizeRoute(String start, List<String> villages) {
        // Simplified route optimization
        villages.sort(Comparator.comparing(v -> 
            routes.getOrDefault(start, Collections.emptyMap()).getOrDefault(v, Integer.MAX_VALUE)
        ));
        return villages;
    }
}