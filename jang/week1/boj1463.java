import java.util.Scanner;
import java.lang.Math;

// 재귀함수를 이용한 경우의 수 완전 탐색
// class Main {
//     static int answer = Integer.MAX_VALUE;

//     static void getMinimumCountOfOperationFromNto1(int n, int count) {
//         // n이 1이 되면 연산을 종료한다.
//         if (n == 1) {
//             answer = Math.min(answer, count);
//             return;
//         }

//         // n이 3으로 나누어 떨어지면 3으로 나눈다.
//         if (n % 3 == 0) getMinimumCountOfOperationFromNto1(n / 3, count + 1);

//         // n이 2로 나누어 떨어지면 2로 나눈다.
//         if (n % 2 == 0) getMinimumCountOfOperationFromNto1(n / 2, count + 1);

//         // 그 외의 경우는 n에서 1을 뺀다.
//         getMinimumCountOfOperationFromNto1(n - 1, count + 1);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // 정수 n을 입력받는다.
//         int n = sc.nextInt();
        
//         // n을 1로 만들기 위한 연산의 최소 횟수를 구한다.
//         getMinimumCountOfOperationFromNto1(n, 0);

//         // 결과를 출력한다.
//         System.out.println(answer);
//     }
// }

// 동적 계획법을 이용한 불필요한 연산 줄이기 (탑다운)
class Main {
    static int[] dp;

    static void getMinimumCountOfOperationFromNto1(int n, int count) {
        // n이 1이 되면 연산을 종료한다.
        if (n == 1) {
            dp[1] = Math.min(dp[1], count);
            return;
        }

        if (dp[n] != Integer.MAX_VALUE && dp[n] <= count) return;
        if (dp[n] > count) dp[n] = count;

        // n이 3으로 나누어 떨어지면 3으로 나눈다.
        if (n % 3 == 0) getMinimumCountOfOperationFromNto1(n / 3, count + 1);

        // n이 2로 나누어 떨어지면 2로 나눈다.
        if (n % 2 == 0) getMinimumCountOfOperationFromNto1(n / 2, count + 1);

        // 그 외의 경우는 n에서 1을 뺀다.
        getMinimumCountOfOperationFromNto1(n - 1, count + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 n을 입력받는다.
        int n = sc.nextInt();

        // 크기가 n + 1인 배열을 생성한다.
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // n을 1로 만들기 위한 연산의 최소 횟수를 구한다.
        getMinimumCountOfOperationFromNto1(n, 0);

        // 결과를 출력한다.
        System.out.println(dp[1]);
    }
}