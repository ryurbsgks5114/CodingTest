import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        dfs(1);

        bufferedWriter.write(Math.min(dp[1][0], dp[1][1]) + "\n");

        bufferedWriter.flush();

    }

    static void dfs(int current) {
        visited[current] = true;
        dp[current][0] = 0;
        dp[current][1] = 1;

        for (int el: tree[current]) {
            if (!visited[el]) {
                dfs(el);

                dp[current][0] += dp[el][1];
                dp[current][1] += Math.min(dp[el][0], dp[el][1]);
            }
        }
    }
}