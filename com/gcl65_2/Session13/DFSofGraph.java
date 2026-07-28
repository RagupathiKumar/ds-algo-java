package gcl65_2.Session13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DFSofGraph {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(0, adj, visited, result);
        return result;
    }

    private void dfs(int vertex, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited, ArrayList<Integer> result) {
        // base case
        if (visited.contains(vertex)) {
            return;
        }

        // recursive case
        result.add(vertex);
        visited.add(vertex);

        for (Integer neighbour : adj.get(vertex)) {
            dfs(neighbour, adj, visited, result);
        }
    }

}
