package gcl65_2.Session14;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList(Arrays.asList(1, 2)));
        adj.add(new ArrayList(Arrays.asList(2)));
        adj.add(new ArrayList(Arrays.asList(3)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList(Arrays.asList(5)));
        adj.add(new ArrayList(Arrays.asList(6, 8)));
        adj.add(new ArrayList(Arrays.asList(7)));
        adj.add(new ArrayList(Arrays.asList(4)));
        adj.add(new ArrayList<>());

        System.out.println(isCyclic(9, adj)); // true
    }

    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] path = new int[V];
        for (int v = 0; v < V; v++) {
            if (isCyclic(v, adj, visited, path)) {
                return true;
            }
        }
        return false;
    }

    static boolean isCyclic(int vertex, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] path) {
        // base case
        if (visited[vertex] == 1) {
            return false;
        }

        // recursive case
        visited[vertex] = 1;
        path[vertex] = 1;
        for (Integer neighbour : adj.get(vertex)) {
            if (path[neighbour] == 1) {
                return true;
            }
            if (isCyclic(neighbour, adj, visited, path)) {
                return true;
            }
        }
        path[vertex] = 0; // backtracking
        return false;
    }

}
