package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1940 {

    static int N, M, s, l;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        s = 0;
        l = N - 1;

        int cnt = 0;

        while (s < l) {
            if (arr[s] + arr[l] < M) {
                s++;
                continue;
            }

            if (arr[s] + arr[l] > M) {
                l--;
                continue;
            }

            if (arr[s] + arr[l] == M) {
                cnt++;
                s++;
                l--;
            }
        }

        System.out.println(cnt);
    }
}
