package core.routing;

import java.util.*;

public class RoutePlanner {
    private final Map<String, Map<String, Integer>> graph;
    private final Map<String, Map<String, Integer>> precomputedDistances;

    public RoutePlanner() {
        this.graph = new HashMap<>();
        this.precomputedDistances = new HashMap<>();
    }

    public void addVillage(String village) {
        graph.putIfAbsent(village, new HashMap<>());
    }

    public void addConnection(String village1, String village2, int distance) {
        graph.putIfAbsent(village1, new HashMap<>());
        graph.putIfAbsent(village2, new HashMap<>());
        graph.get(village1).put(village2, distance);
        graph.get(village2).put(village1, distance);
        precomputeDistances();
    }

    public List<String> planRoute(String start, List<String> destinations) {
        if (!precomputedDistances.containsKey(start)) {
            precomputeForVillage(start);
        }

        // Sort destinations by distance from start
        destinations.sort(Comparator.comparingInt(v -> 
            precomputedDistances.get(start).getOrDefault(v, Integer.MAX_VALUE)));

        // Nearest neighbor algorithm
        List<String> route = new ArrayList<>();
        String current = start;
        Set<String> unvisited = new HashSet<>(destinations);

        while (!unvisited.isEmpty()) {
            String nearest = null;
            int minDistance = Integer.MAX_VALUE;

            for (String village : unvisited) {
                int dist = getDistance(current, village);
                if (dist < minDistance) {
                    minDistance = dist;
                    nearest = village;
                }
            }

            if (nearest != null) {
                route.add(nearest);
                unvisited.remove(nearest);
                current = nearest;
            } else {
                break;
            }
        }

        return route;
    }

    private void precomputeDistances() {
        for (String village : graph.keySet()) {
            precomputeForVillage(village);
        }
    }

    private void precomputeForVillage(String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(
            Comparator.comparingInt(v -> distances.getOrDefault(v, Integer.MAX_VALUE)));

        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (Map.Entry<String, Integer> neighbor : graph.get(current).entrySet()) {
                int newDist = distances.get(current) + neighbor.getValue();
                if (newDist < distances.getOrDefault(neighbor.getKey(), Integer.MAX_VALUE)) {
                    distances.put(neighbor.getKey(), newDist);
                    queue.add(neighbor.getKey());
                }
            }
        }

        precomputedDistances.put(start, distances);
    }

    private int getDistance(String from, String to) {
        return precomputedDistances.getOrDefault(from, Collections.emptyMap())
            .getOrDefault(to, Integer.MAX_VALUE);
    }
}