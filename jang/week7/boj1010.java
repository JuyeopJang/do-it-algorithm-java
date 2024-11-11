import java.util.Scanner;

public class boj1010 {

    public static long nCr(int n, int r) {
        int[][] dp = new int[n + 1][r + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= r; j++) {
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][r];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long answer = nCr(m, n);
            System.out.println(answer);
        }
    }
}
