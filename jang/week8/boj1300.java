import java.util.*;

class boj1300 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        long N = scanner.nextLong();
        long k = scanner.nextLong();

        // k번째 수를 찾기
        System.out.println(findKthNumber(N, k));
    }

    public static long findKthNumber(long N, long k) {
        // 이진 탐색 범위 설정
        long left = 1, right = N * N;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid 이하의 숫자 개수 계산
            if (countLessEqual(mid, N) >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static long countLessEqual(long x, long N) {
        long count = 0;

        // 각 행에서 x보다 작거나 같은 숫자의 개수를 더함
        for (int i = 1; i <= N; i++) {
            count += Math.min(x / i, N);
        }

        return count;
    }
}
