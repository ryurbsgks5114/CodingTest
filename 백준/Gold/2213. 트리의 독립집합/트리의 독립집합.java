import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] tree;
    static int[] weight;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        weight = new int[N + 1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1);

        int maxValue = Math.max(dp[1][0], dp[1][1]);

        bufferedWriter.write(maxValue + "\n");

        visited = new boolean[N + 1];

        reconstruct(1, dp[1][1] > dp[1][0]);

        Collections.sort(result);

        for (int el: result) {
            bufferedWriter.write(el + " ");
        }

        bufferedWriter.flush();

    }

    public static void dfs(int cur) {
        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = weight[cur];

        for (int el: tree[cur]) {
            if (!visited[el]) {
                dfs(el);

                dp[cur][0] += Math.max(dp[el][0], dp[el][1]);
                dp[cur][1] += dp[el][0];
            }
        }
    }

    public static void reconstruct(int cur, boolean isSelected) {
        visited[cur] = true;

        if (isSelected) {
            result.add(cur);
        }

        for (int el: tree[cur]) {
            if (!visited[el]) {
                if (isSelected) {
                    reconstruct(el, false);
                } else {
                    reconstruct(el, dp[el][1] > dp[el][0]);
                }
            }
        }
    }
}