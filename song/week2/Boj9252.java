package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj9252 {

    static char[] str1, str2;
    static int[][] dp;
    static List<Character> lcs;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new int[str1.length + 1][str2.length + 1];
        lcs = new ArrayList<>();

        for (int i = 1; i < str1.length + 1; i++) {
            for (int j = 1; j < str2.length + 1; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length][str2.length]);

        getText(str1.length, str2.length);

        StringBuilder sb = new StringBuilder();
        for (int i = lcs.size() - 1; i >= 0; i--) {
            sb.append(lcs.get(i));
        }

        System.out.println(sb);

    }

    public static void getText(int r, int c) {
        if (r == 0 || c == 0) {
            return;
        }

        if (str1[r - 1] == str2[c - 1]) {
            lcs.add(str1[r - 1]);
            getText(r - 1, c - 1);
        } else {
            if (dp[r - 1][c] > dp[r][c - 1]) {
                getText(r -1, c);
            } else{
                getText(r, c-1);
            }
        }
    }

}
