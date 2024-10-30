import java.math.BigInteger;
import java.util.Scanner;

class Boj2343 {

    public static BigInteger binomial(int n, int k) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i))
                    .divide(BigInteger.valueOf(i + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        BigInteger totalCases = binomial(n + m, n);
        
        if (totalCases.compareTo(BigInteger.valueOf(k)) < 0) {
            System.out.println("-1");
            return;
        }

        while (n > 0 && m > 0) {
            BigInteger aCases = binomial(n + m - 1, n - 1);

            if (aCases.compareTo(BigInteger.valueOf(k)) >= 0) {
                answer.append("a");
                n--;
            } else {
                answer.append("z");
                m--;
                k -= aCases.intValue();
            }
        }

        while (n-- > 0) answer.append("a");
        while (m-- > 0) answer.append("z");

        System.out.println(answer);
    }
}