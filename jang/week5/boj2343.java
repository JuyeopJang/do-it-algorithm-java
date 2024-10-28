import java.util.*;

class Boj2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] lessons = new int[n];
        int maxLessonLength = 0;
        int totalLength = 0;

        for (int i = 0; i < n; i++) {
            lessons[i] = sc.nextInt();
            maxLessonLength = Math.max(maxLessonLength, lessons[i]);
            totalLength += lessons[i];
        }

        int left = maxLessonLength;
        int right = totalLength;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (sum + lessons[i] > mid) {
                    cnt++;
                    sum = lessons[i];
                } else {
                    sum += lessons[i];
                }
            }

            if (cnt <= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}