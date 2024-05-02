package gcl65.Session13;

import java.util.ArrayList;

public class DFSofGraph {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        dfsOfGraph(adj, 0, visited, result);
        return result;
    }

    private void dfsOfGraph(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited, ArrayList<Integer> result) {
        // base case
        if (visited[v]) {
            return;
        }

        // recursive case
        result.add(v);
        visited[v] = true;

        for (Integer neighbour : adj.get(v)) {
            dfsOfGraph(adj, neighbour, visited, result);
        }
    }

}