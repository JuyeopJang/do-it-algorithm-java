import java.util.*;

class boj2342 {
    // dp[l][r][i] = 왼발이 l, 오른발이 r에 있을 때 i번째 지시사항을 따를 때의 최소 비용
    public static int[][][] dp;
    public static ArrayList<Integer> op;
    
    // 발을 움직이는 비용을 계산하는 함수
    public static int getMoveCost(int from, int to) {
        if (from == 0) return 2; // 처음 움직일 때는 2
        if (from == to) return 1; // 같은 발판으로 이동할 때는 1
        if (Math.abs(from - to) == 2) return 4; // 반대 발판으로 이동할 때는 4
        return 3; // 인접한 발판으로 이동할 때는 3
    }

    public static int move(int curLeftFoot, int curRightFoot, int index, int n) {
        // 모든 지시를 완료한 경우
        if (index == n) return 0;

        // 이미 계산된 경우 그 값을 반환
        if (dp[curLeftFoot][curRightFoot][index] != -1) {
            return dp[curLeftFoot][curRightFoot][index];
        }

        int nextDirection = op.get(index);

        // 왼발을 움직이는 경우
        int leftMoveCost = move(nextDirection, curRightFoot, index + 1, n) + getMoveCost(curLeftFoot, nextDirection);
        
        // 오른발을 움직이는 경우
        int rightMoveCost = move(curLeftFoot, nextDirection, index + 1, n) + getMoveCost(curRightFoot, nextDirection);

        // 현재 상태에서 최소 비용을 저장
        dp[curLeftFoot][curRightFoot][index] = Math.min(leftMoveCost, rightMoveCost);
        return dp[curLeftFoot][curRightFoot][index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        op = new ArrayList<>();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            op.add(n);
        }

        int size = op.size();
        dp = new int[5][5][size]; // 발판은 0부터 4까지 존재

        // dp 배열을 -1로 초기화 (아직 계산되지 않은 상태를 의미)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // 초기에는 양발이 0에 있는 상태로 시작
        System.out.println(move(0, 0, 0, size));
    }
}
