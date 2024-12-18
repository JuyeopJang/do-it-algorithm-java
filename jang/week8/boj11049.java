import java.util.*;

class boj11049 {
    static int n;
    static Matrix[] matrix;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new Matrix[n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            matrix[i] = new Matrix(sc.nextInt(), sc.nextInt());
        }

        System.out.println(solve(1, n));
    }

    static int solve(int start, int end) {
        if (start == end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        dp[start][end] = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            dp[start][end] = Math.min(dp[start][end], solve(start, i) + solve(i + 1, end) + matrix[start].x * matrix[i].y * matrix[end].y);
        }

        return dp[start][end];
    }

    static class Matrix {
        private int x;
        private int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}