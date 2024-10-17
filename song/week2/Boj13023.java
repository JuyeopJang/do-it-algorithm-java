package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj13023 {

    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        for (int i = 0; i < N; i++) {
            dfs(1, i);
            Arrays.fill(visited, false);

            if (answer == 1) {
                break;
            }
        }

        System.out.println(answer);


    }

    public static void dfs(int depth, int node) {

        if (depth == 5) {
            answer = 1;
            return;
        }

        visited[node] = true;

        for (int next : adj[node]) {
            if (!visited[next]) {
                dfs(depth + 1, next);
            }
        }
        visited[node] = false;
    }
}
