import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj12738 {
    public static int lowerBound(int left, int right, int target, List<Integer> lis) {
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (lis.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        lis.add(arr[0]);

        for (int i = 1; i < n; i++) {
            int last = lis.get(lis.size() - 1);

            if (last < arr[i]) {
                lis.add(arr[i]);
            } else {
                int idx = lowerBound(0, lis.size() - 1, arr[i], lis);
                lis.set(idx, arr[i]);
            }
        }

        System.out.println(lis.size());
    }
}
