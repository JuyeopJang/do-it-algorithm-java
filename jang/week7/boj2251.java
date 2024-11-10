import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj2251 {
    static boolean[][][] visited;
    static int A;
    static int B;
    static int C;
    static List<Integer> result = new ArrayList<>();

    public static void dfs(int a, int b, int c) {
        if (visited[a][b][c]) return;
        if (a == 0 && !result.contains(c)) {
            result.add(c);
        }

        visited[a][b][c] = true;

        // A -> B
        int move = Math.min(a, B - b);
        dfs(a - move, b + move, c);

        // A -> C
        move = Math.min(a, C - c);
        dfs(a - move, b, c + move);

        // B -> A
        move = Math.min(b, A - a);
        dfs(a + move, b - move, c);

        // B -> C
        move = Math.min(b, C - c);
        dfs(a, b - move, c + move);

        // C -> A
        move = Math.min(c, A - a);
        dfs(a + move, b, c - move);

        // C -> B
        move = Math.min(c, B - b);
        dfs(a, b + move, c - move);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        visited = new boolean[201][201][201];

        dfs(0, 0, C);

        result.sort(null);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
