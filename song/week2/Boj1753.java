package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1753 {

    static int V, E, K;
    static boolean[] visited;
    static int[] dist;
    static List<Edge> list[];
    static PriorityQueue<Edge> queue = new PriorityQueue<>();


    static class Edge implements  Comparable<Edge>{
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            if (this.weight < o.weight) {
                return -1;
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, w));
        }

        queue.add(new Edge(K, 0));
        dist[K] = 0;

        while (!queue.isEmpty()) {
            Edge curr = queue.poll();
            int cv = curr.vertex;

            if (visited[cv]) {
                continue;
            }

            visited[cv] = true;

            for (int i = 0; i < list[cv].size(); i++) {
                Edge next = list[cv].get(i);

                int nv = next.vertex;
                int nw = next.weight;

                if (dist[nv] > dist[cv] + nw) {
                    dist[nv] = dist[cv] + nw;
                    queue.add(new Edge(nv, dist[nv]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (visited[i]) {
                sb.append(dist[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }
        System.out.print(sb);
    }
}
