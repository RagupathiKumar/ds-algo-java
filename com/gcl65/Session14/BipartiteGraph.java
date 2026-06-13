package gcl65.Session14;

import java.util.Deque;
import java.util.LinkedList;

public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) {
                continue;
            }

            Deque<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int node = q.pop();

                for (int neighbour : graph[node]) {
                    if (color[neighbour] == color[node]) {
                        return false;
                    }

                    if (color[neighbour] == 0) {
                        q.add(neighbour);
                        color[neighbour] = -color[node];
                    }
                }
            }
        }

        return true;
    }

}