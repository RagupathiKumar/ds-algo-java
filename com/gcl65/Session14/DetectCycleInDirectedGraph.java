package gcl65.Session14;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];

        /**
         * did not understand the purpose of below for loop
         * my guess is this is added due to the nature of the problem execution in GFG
         * coz, below for loop states that we cannot navigate through the entire graph using DFS (which is wrong)
         * */

        for (int i = 0; i < V; i++) { // Chaman -- this is for graph with multiple component
            if (isCyclic(i, visited, path, adj)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclic(int v, boolean[] visited, boolean[] path, ArrayList<ArrayList<Integer>> adj) {
        // base case
        if (visited[v] && path[v]) { // cycle found
            return true;
        } else if (visited[v]) { // already visited
            return false;
        }

        // recursive case
        visited[v] = true;
        path[v] = true; // added to current path
        for (Integer neighbour : adj.get(v)) {
            if (isCyclic(neighbour, visited, path, adj)) {
                return true;
            }
        }
        path[v] = false; // backtracking - removed from current path
        return false;
    }


}