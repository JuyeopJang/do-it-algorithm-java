import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class boj1167 {
    static class Node {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int[] dfs(int vertex, int distance, HashMap<Integer, List<Node>> tree, boolean[] visited) {
        visited[vertex] = true;
        int[] result = {vertex, distance};

        for (Node node : tree.get(vertex)) {
            if (!visited[node.v]) {
                int[] temp = dfs(node.v, distance + node.w, tree, visited);

                if (temp[1] > result[1]) {
                    result = temp;
                }
            }
        }

        visited[vertex] = false;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[] visited = new boolean[n + 1];

        HashMap<Integer, List<Node>> tree = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            int node = sc.nextInt();

            while (true) {
                int next = sc.nextInt();

                if (next == -1) {
                    break;
                }

                int weight = sc.nextInt();

                tree.get(node).add(new Node(next, weight));
            }
        }

        int a = dfs(1, 0, tree, visited)[0];
        int answer = dfs(a, 0, tree, visited)[1];

        System.out.println(answer);
    }
}
