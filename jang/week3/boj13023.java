import java.util.*;

class Boj13023 {
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static boolean answer = false;

    static void dfs(int key, List<Integer> visited) {
        if (visited.size() == 5) {
            answer = true;
            return;
        }

        for (Integer next : map.getOrDefault(key, Collections.emptyList())) {
            if (visited.contains(next)) {
                continue;
            }

            visited.add(next);
            dfs(next, visited);
            visited.remove(visited.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }

            map.get(a).add(b);
            map.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> visited = new ArrayList<>();
            visited.add(i);
            dfs(i, visited);

            if (answer) break;
        }

        System.out.println(answer ? 1 : 0);
    }
}