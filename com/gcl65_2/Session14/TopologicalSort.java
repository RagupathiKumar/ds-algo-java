package gcl65_2.Session14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0)));
        System.out.println(Arrays.toString(topoSort(4, adj))); // 123 0

        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList<>());
        adj2.add(new ArrayList<>(List.of(3)));
        adj2.add(new ArrayList<>(List.of(3)));
        adj2.add(new ArrayList<>());
        adj2.add(new ArrayList<>(List.of(0, 1)));
        adj2.add(new ArrayList<>(List.of(0, 2)));
        System.out.println(Arrays.toString(topoSort(6, adj2))); // 54 21 03

        ArrayList<ArrayList<Integer>> adj3 = new ArrayList<>();
        adj3.add(new ArrayList<>(List.of(1)));
        adj3.add(new ArrayList<>(List.of(2)));
        adj3.add(new ArrayList<>(List.of(3, 4)));
        adj3.add(new ArrayList<>());
        adj3.add(new ArrayList<>(List.of(5)));
        adj3.add(new ArrayList<>());
        System.out.println(Arrays.toString(topoSort(6, adj3))); // 0 1 2 4 35
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int v = 0; v < V; v++) {
            topoSort(v, adj, visited, st);
        }
        int[] result = new int[V];
        for (int i = 0; i < V; i++) {
            result[i] = st.pop();
        }
        return result;
    }

    static void topoSort(int vertex, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack) {
        // base case
        if (visited[vertex] == 1) {
            return;
        }

        // recursive case
        visited[vertex] = 1;
        for (Integer neighbour : adj.get(vertex)) {
            topoSort(neighbour, adj, visited, stack);
        }
        stack.push(vertex);
    }

}
