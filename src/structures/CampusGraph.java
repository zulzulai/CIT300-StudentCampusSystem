package structures;

import java.util.*;

public class CampusGraph {

    private Map<String, List<String>> adj = new LinkedHashMap<>();

    public boolean addLocation(String name) {
        if (adj.containsKey(name)) return false;
        adj.put(name, new ArrayList<>());
        return true;
    }

    public boolean removeLocation(String name) {
        if (!adj.containsKey(name)) return false;
        adj.remove(name);
        for (List<String> list : adj.values()) list.remove(name);
        return true;
    }

    public boolean addConnection(String a, String b) {
        if (!adj.containsKey(a) || !adj.containsKey(b)) return false;
        if (adj.get(a).contains(b)) return false;
        adj.get(a).add(b);
        adj.get(b).add(a); // undirected
        return true;
    }

    public boolean removeConnection(String a, String b) {
        if (!adj.containsKey(a) || !adj.containsKey(b)) return false;
        adj.get(a).remove(b);
        adj.get(b).remove(a);
        return true;
    }

    public void displayConnections() {
        if (adj.isEmpty()) { System.out.println("No locations."); return; }
        for (String loc : adj.keySet())
            System.out.println(loc + " -> " + adj.get(loc));
    }

    public void bfs(String start) {
        if (!adj.containsKey(start)) { System.out.println("No such location."); return; }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start); visited.add(start);
        while (!q.isEmpty()) {
            String cur = q.poll();
            System.out.print(cur + " ");
            for (String nb : adj.get(cur))
                if (!visited.contains(nb)) { visited.add(nb); q.add(nb); }
        }
        System.out.println();
    }

    public void dfs(String start) {
        if (!adj.containsKey(start)) { System.out.println("No such location."); return; }
        Set<String> visited = new HashSet<>();
        dfsRec(start, visited);
        System.out.println();
    }

    private void dfsRec(String cur, Set<String> visited) {
        visited.add(cur);
        System.out.print(cur + " ");
        for (String nb : adj.get(cur))
            if (!visited.contains(nb)) dfsRec(nb, visited);
    }
}
