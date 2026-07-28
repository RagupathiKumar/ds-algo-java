package gcl65_2.Session13;

import java.util.*;

public class BFSofGraph {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited.add(0);
        while (!q.isEmpty()) {
            Integer v = q.poll();
            result.add(v);

            for (Integer neighbour : adj.get(v)) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return result;
    }

}
