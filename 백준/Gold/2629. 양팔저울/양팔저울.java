import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] dp;
    static int[] weights;
    static int W;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        weights = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int sum = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(stringTokenizer.nextToken());
            sum += weights[i];
        }

        W = sum;
        dp = new boolean[n + 1][W + 1];
        dfs(0, 0);

        int t = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (t-- > 0) {

            int marble = Integer.parseInt(stringTokenizer.nextToken());

            if (marble > W) {
                stringBuilder.append("N ");
            } else {
                stringBuilder.append(dp[n][marble] ? "Y " : "N ");
            }
        }

        bufferedWriter.write(stringBuilder + "\n");

        bufferedWriter.flush();

    }

    public static void dfs(int index, int weight) {
        if (dp[index][weight]) {
            return;
        }

        dp[index][weight] = true;

        if (index == weights.length) {
            return;
        }

        int w = weights[index];

        dfs(index + 1, weight);
        dfs(index + 1, weight + w);
        dfs(index + 1, Math.abs(weight - w));
    }
}