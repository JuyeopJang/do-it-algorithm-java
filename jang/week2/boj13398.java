import java.util.*;

class boj13398 {
    static int[] arr;
    static int[] dpL;
    static int[] dpR;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];
        dpL = new int[n];
        dpR = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dpL[i] = 0;
            dpR[i] = 0;
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        dpL[0] = arr[0];
        dpR[n - 1] = arr[n - 1];

        int max = dpL[0];

        for (int i = 1; i < n; i++) {
            dpL[i] = Math.max(arr[i], dpL[i - 1] + arr[i]);
            max = Math.max(max, dpL[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            dpR[i] = Math.max(arr[i], dpR[i + 1] + arr[i]);
        }

        for (int i = 0; i < n; i++) {
            int temp;

            if (i == 0) temp = dpR[i + 1];
            else if (i == n - 1) temp = dpL[i - 1];
            else temp = dpL[i - 1] + dpR[i + 1];

            max = Math.max(max, temp);
        }

        System.out.println(max);

        sc.close();
    }
}
