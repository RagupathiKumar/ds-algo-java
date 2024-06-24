package gcl65.Session14;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraAlgorithm {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int target = 0; target < V; target++) {
            int[] visited = new int[V];
            int weight = 0;
            dfs(S, target, adj, visited, dist, weight);
        }

        return dist;
    }

    private static void dfs(int src, int target, ArrayList<ArrayList<ArrayList<Integer>>> adj,
                            int[] visited, int[] dist, int weight) {

        // base case
        if (src == target) {
            dist[target] = Math.min(dist[target], weight);
            return;
        } else if (visited[src] == 1) {
            return;
        }

        // recursive case
        visited[src] = 1;

        ArrayList<ArrayList<Integer>> adjNodes = adj.get(src);
        for (ArrayList<Integer> adjNode : adjNodes) {
            int node = adjNode.get(0);
            int w = adjNode.get(1);
            dfs(node, target, adj, visited, dist, weight + w);
        }

        visited[src] = 0;
    }

}