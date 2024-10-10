import java.util.*;

class boj1940 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = n - 1;
        int cnt = 0;

        while (p1 < p2) {
            if (arr[p1] + arr[p2] == m) {
                cnt += 1;
                p1 += 1;
                p2 -= 1;
            } else if (arr[p1] + arr[p2] < m) {
                p1 += 1;
            } else {
                p2 -= 1;
            }
        }

        System.out.println(cnt);

        sc.close();
    }
}