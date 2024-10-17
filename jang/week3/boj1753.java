import java.util.*;

class boj1753 {
    private static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        List<List<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }


        int m = sc.nextInt();
        int start = sc.nextInt() - 1;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int w = sc.nextInt();

            graph.get(a).add(new Node(b, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.vertex;

            for (Node neighbor : graph.get(cur)) {
                if (dist[cur] != INF && dist[cur] + neighbor.weight < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = dist[cur] + neighbor.weight;
                    pq.add(new Node(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }    
}
