package gcl65.Session13;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BFSofGraph {

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Deque<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            Integer v = q.poll();
            result.add(v);

            for (Integer neighbour : adj.get(v)) {
                if (visited[neighbour]) {
                    continue;
                }
                q.add(neighbour);
                visited[neighbour] = true;
            }
        }

        return result;
    }

}