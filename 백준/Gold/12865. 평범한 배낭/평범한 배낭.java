import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            weights[i] = Integer.parseInt(stringTokenizer.nextToken());
            values[i] = Integer.parseInt(stringTokenizer.nextToken());

        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        bufferedWriter.write(String.valueOf(dp[N][K]));

        bufferedWriter.flush();

    }
}