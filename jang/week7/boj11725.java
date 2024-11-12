import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj11725 {
    static int[] parent;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        parent = new int[n + 1];
        visited = new int[n + 1];

        HashMap<Integer, List<Integer>> tree = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            visited[node] = 1;

            for (int next: tree.get(node)) {
                if (visited[next] == 0) {
                    parent[next] = node;
                    queue.add(next);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
