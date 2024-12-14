import java.util.Arrays;
import java.util.Scanner;

public class boj2098 {
    private static final int INF = 1_000_000_000; // 무한대 값 대체
    private static int N; // 도시의 수
    private static int[][] W; // 비용 행렬
    private static int[][] dp; // DP 테이블

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 도시 수 입력
        N = sc.nextInt();
        W = new int[N][N];
        dp = new int[N][1 << N];

        // 비용 행렬 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        // DP 테이블 초기화
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // 시작 도시에서 출발해 최소 비용 계산
        int result = tsp(0, 1); // 0번 도시에서 시작, 첫 번째 비트 켜짐
        System.out.println(result);
    }

    // TSP 해결 함수 (현재 도시, 방문 상태)
    private static int tsp(int current, int visited) {
        // 모든 도시 방문 완료 후 시작 도시로 돌아가는 비용 반환
        if (visited == (1 << N) - 1) {
            return W[current][0] == 0 ? INF : W[current][0]; // 경로가 없으면 INF 반환
        }

        // 이미 계산된 값이 있으면 반환 (메모이제이션)
        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        // 최소 비용 계산
        int minCost = INF;

        for (int next = 0; next < N; next++) {
            // 다음 도시가 방문되지 않았고, 경로가 있을 때
            if ((visited & (1 << next)) == 0 && W[current][next] != 0) {
                int cost = W[current][next] + tsp(next, visited | (1 << next));
                minCost = Math.min(minCost, cost);
            }
        }

        // 결과 저장 후 반환
        return dp[current][visited] = minCost;
    }
}
