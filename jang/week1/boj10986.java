import java.util.Scanner;
import java.util.HashMap;


class Boj10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n];
        long answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long[] prefix = new long[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        long countDevidedByM = 0;  // Change to long
        HashMap<Long, Long> map = new HashMap<>();  // Change to Long

        for (int i = 0; i < n; i++) {
            long remainder = prefix[i] % m;  // Make remainder long
            if (remainder < 0) remainder += m;  // To handle negative remainders if needed
            
            if (remainder == 0) {
                countDevidedByM++;
            } else {
                map.put(remainder, map.getOrDefault(remainder, 0L) + 1); // Use getOrDefault for cleaner code
            }
        }

        answer = countDevidedByM; // Start with the count of exact divisions
        answer += countDevidedByM * (countDevidedByM - 1) / 2; // Combinations of the countDevidedByM

        // Calculate combinations of the counts from map
        for (long v : map.values()) {
            answer += (v * (v - 1)) / 2;  // Combination count
        }

        System.out.println(answer);
    }
}