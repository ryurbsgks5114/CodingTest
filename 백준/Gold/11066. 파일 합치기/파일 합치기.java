import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        int[][] dp;
        int[] sum;
        int[] files;

        while (T-- > 0) {

            int K = Integer.parseInt(bufferedReader.readLine());

            files = new int[K + 1];
            sum = new int[K + 1];
            dp = new int[K + 1][K + 1];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(stringTokenizer.nextToken());
                sum[i] = sum[i - 1] + files[i];
            }

            for (int len = 2; len <= K; len++) {
                for (int i = 1; i <= K - len + 1; i++) {

                    int j = i + len - 1;

                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {

                        int cost = dp[i][k] + dp[k + 1][j] + (sum[j] - sum[i - 1]);

                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }

            bufferedWriter.write(dp[1][K] + "\n");
        }

        bufferedWriter.flush();

    }
}