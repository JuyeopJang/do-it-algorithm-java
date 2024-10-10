package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13398 {

    static int N;
    static int[] arr;
    static int[] L;
    static int[] R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        L = new int[N];
        R = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        L[0] = arr[0];
        R[N - 1] = arr[N - 1];

        int answer = L[0];

        for (int i = 1; i < N; i++) {
            L[i] = Math.max(arr[i], L[i - 1] + arr[i]);
            answer = Math.max(answer, L[i]);
        }

        for (int i = N - 2; i >= 0; i--) {
            R[i] = Math.max(arr[i], R[i + 1] + arr[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            int temp = L[i - 1] + R[i + 1];
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);

    }
}
