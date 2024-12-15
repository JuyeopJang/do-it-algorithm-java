import java.util.*;

class boj1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int lp = 0;
            int rp = n - 1;

            while (lp < rp) {
                if (lp == i) {
                    lp++;
                    continue;
                }

                if (rp == i) {
                    rp--;
                    continue;
                }

                if (arr[lp] + arr[rp] == arr[i]) {
                    answer++;
                    break;
                } else if (arr[lp] + arr[rp] < arr[i]) {
                    lp++;
                    continue;
                } else {
                    rp--;
                    continue;
                }
            }
        }

        System.out.println(answer);
    }
}