import java.util.*;

class Boj1197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<List<Integer>>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph.get(from).add(List.of(weight, to));
            graph.get(to).add(List.of(weight, from));
        }

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));

        pq.add(List.of(0, 1));

        boolean[] visited = new boolean[n + 1];

        int result = 0;

        while (!pq.isEmpty()) {
            List<Integer> edge = pq.poll();

            int weight = edge.get(0);
            int next = edge.get(1);

            if (visited[next]) {
                continue;
            }

            visited[next] = true;
            result += weight;

            for (int i = 0; i < graph.get(next).size(); i++) {
                int nextWeight = graph.get(next).get(i).get(0);
                int nextNode = graph.get(next).get(i).get(1);

                if (!visited[nextNode]) {
                    pq.add(List.of(nextWeight, nextNode));
                }
            }
        }

        System.out.println(result);
    }
}
