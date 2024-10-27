import java.util.*;

class Boj1722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int type = sc.nextInt();

        if (type == 1) {
            long k = sc.nextLong();
            List<Integer> numbers = new ArrayList<>();
            List<Integer> permutation = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }

            k--;

            for (int i = n; i > 0; i--) {                
                long factorial = 1;

                for (int j = 1; j < i; j++) {
                    factorial *= j;
                }

                int index = (int) (k / factorial);

                permutation.add(numbers.remove(index));
                k %= factorial;
            }

            for (int i = 0; i < permutation.size(); i++) {
                System.out.print(permutation.get(i) + " ");
            }
        } else {
            int[] arr = new int[n];
            long result = 1;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean[] check = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                int num = arr[i];

                for (int j = 1; j < num; j++) {
                    long factorial = 1;

                    for (int k = 1; k < n - i; k++) {
                        factorial *= k;
                    }

                    if (!check[j]) {
                        result += factorial;
                    }
                }

                check[num] = true;
            }

            System.out.println(result);
        }
    }
}