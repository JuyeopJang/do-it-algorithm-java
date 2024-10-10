import java.util.*;

class Boj2023 {
    static ArrayList<Integer> answers = new ArrayList<>();
    static int[] firstNumbers = {2, 3, 5, 7};  // 첫 자리에는 소수만 허용
    static int maxDigits;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        maxDigits = sc.nextInt();

        for (int firstNumber : firstNumbers) {
            createWeirdPrime(firstNumber, 1);  // 첫 자리는 1자리 숫자
        }

        Collections.sort(answers);

        for (int answer : answers) {
            System.out.println(answer);
        }
    }

    // 재귀적으로 숫자를 생성하고 소수를 체크하는 함수
    static void createWeirdPrime(int currentNum, int digits) {
        if (digits == maxDigits) {
            // 최대 자릿수에 도달하면 종료
            if (isPrime(currentNum)) {
                answers.add(currentNum);  // 소수일 경우에만 추가
            }
            return;
        }

        // 0 ~ 5까지의 홀수 (1, 3, 5, 7, 9) 추가
        for (int i = 0; i < 5; i++) {
            int newNum = Integer.parseInt(currentNum + String.valueOf(i * 2 + 1));

            // 소수일 때만 재귀적으로 호출
            if (isPrime(newNum)) {
                createWeirdPrime(newNum, digits + 1);  // 다음 자리로 이동
            }
        }
    }

    // 소수 판별 함수
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}