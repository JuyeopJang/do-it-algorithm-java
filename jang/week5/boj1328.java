import java.util.Scanner;

class Boj1328 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        

        long dp[][][] = new long[101][101][101];
        dp[1][1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + dp[i - 1][j][k] * (i - 2)) % MOD;
                }
            }
        }

        System.out.println(dp[n][l][r]);
    }
}