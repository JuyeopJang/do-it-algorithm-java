import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class boj11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 총 수의 개수
        int L = Integer.parseInt(firstLine[1]); // 슬라이딩 윈도우 크기
        int[] A = new int[N];
        
        String[] numbers = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(numbers[i]);
        }
        
        int[] result = findSlidingWindowMin(A, L);
        
        // 결과 출력
        StringBuilder output = new StringBuilder();
        for (int value : result) {
            output.append(value).append(" ");
        }
        System.out.println(output.toString().trim());
    }

    public static int[] findSlidingWindowMin(int[] A, int L) {
        int N = A.length;
        int[] D = new int[N];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            // 덱에서 윈도우 범위를 벗어난 인덱스를 제거
            if (!deque.isEmpty() && deque.peekFirst() <= i - L) {
                deque.pollFirst();
            }

            // 덱의 끝에 있는 값보다 현재 값이 작으면 끝의 값을 제거
            while (!deque.isEmpty() && A[deque.peekLast()] >= A[i]) {
                deque.pollLast();
            }

            // 현재 인덱스를 덱에 추가
            deque.offerLast(i);

            // 현재 윈도우의 최솟값을 D에 저장 (덱의 첫 번째 요소가 최솟값)
            D[i] = A[deque.peekFirst()];
        }

        return D;
    }
}