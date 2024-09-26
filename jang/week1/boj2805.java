import java.util.Arrays;
import java.util.Scanner;

class Boj2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int treeNumber = sc.nextInt();
        int treeLength = sc.nextInt();
        long answer = 0;

        long[] trees = new long[treeNumber];

        for (int i = 0; i < treeNumber; i++) {
            trees[i] = sc.nextInt();
        }

        long minHeight = 0;
        long maxHeight = Arrays.stream(trees).max().getAsLong();;

        while (minHeight <= maxHeight) {
            long height = (minHeight + maxHeight) / 2;
            long sum = 0;
            
            for (int i = 0; i < treeNumber; i++) {
                if (trees[i] > height) {
                    sum += trees[i] - height;
                }
            }

            if (sum >= treeLength) {
                minHeight = height + 1;
                answer = Math.max(answer, height);
            } else {
                maxHeight = height - 1;
            }
        }

        System.out.println(answer);
    }
}