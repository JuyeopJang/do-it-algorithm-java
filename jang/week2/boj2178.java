import java.util.*;

class Boj2178 {
    static int rows;
    static int cols;
    static int[][] maze;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<List<Integer>> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

        int[][] maze = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];   

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("");

            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(parts[j]);
                visited[i][j] = false;
                dist[i][j] = 0;
            }
        }

        queue.add(Arrays.asList(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();

            int x = current.get(0);
            int y = current.get(1);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maze[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(Arrays.asList(nx, ny));
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

        System.out.println(dist[n-1][m-1]);

        sc.close();
    }
}