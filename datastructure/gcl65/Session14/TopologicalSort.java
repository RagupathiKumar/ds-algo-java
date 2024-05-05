package gcl65.Session14;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    //Function to return list containing vertices in Topological order.
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();

        // adding for loop since multiple components are possible
        for (int v = 0; v < V; v++) {
            topoSort(adj, v, visited, s);
        }

        int[] result = new int[V];
        for (int i = 0; i < V; i++) {
            result[i] = s.pop();
        }
        return result;
    }

    private void topoSort(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited, Stack<Integer> s) {
        // base case
        if (visited[v]) {
            return;
        }

        // recursive case
        visited[v] = true;
        for (Integer neighbour : adj.get(v)) {
            topoSort(adj, neighbour, visited, s);
        }
        s.push(v);
    }

}