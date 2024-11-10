import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Boj1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 엣지 개수

        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // 그래프의 방향을 반대로 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reverseGraph.get(b).add(a);
        }

        int[] hackableCount = new int[n + 1]; // 각 노드에서 해킹할 수 있는 컴퓨터 수
        int maxCount = 0; // 최댓값 추적

        // 각 노드를 시작점으로 BFS 실행
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            int count = 1;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int neighbor : reverseGraph.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                        count++;
                    }
                }
            }

            hackableCount[i] = count;
            maxCount = Math.max(maxCount, count);
        }

        // 최대값을 가진 노드들 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hackableCount[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
