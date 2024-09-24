import java.util.Scanner;

class Boj1520 {
    static int rows;
    static int cols;
    static int[][] matrix;
    static int[][] dp;

    static int move(int x, int y) {
        if (x == rows - 1 && y == cols - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int count = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && matrix[nx][ny] < matrix[x][y]) {
                count += move(nx, ny);
            }
        }

        dp[x][y] = count;

        return dp[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        rows = sc.nextInt();
        cols = sc.nextInt();
        
        matrix = new int[rows][cols];
        dp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(move(0, 0));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}