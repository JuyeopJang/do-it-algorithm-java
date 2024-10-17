import java.util.*;

class Boj18352 {
    static HashMap<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (map.containsKey(a)) {
                map.get(a).add(b);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a, list);
            }
        }

        int[] dist = new int[n + 1];

        List<Integer> queue = new ArrayList<>();

        queue.add(x);

        while (!queue.isEmpty()) {
            int cur = queue.remove(0);

            if (map.containsKey(cur)) {
                for (Integer next : map.get(cur)) {
                    if (x == next) {
                        continue;
                    }
                    if (dist[next] == 0) {
                        dist[next] = dist[cur] + 1;
                        queue.add(next);
                    } else {
                        dist[next] = Math.min(dist[next], dist[cur] + 1);
                    }
                }
            }
        }

        boolean flag = false;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                flag = true;
                System.out.println(i);
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }
}