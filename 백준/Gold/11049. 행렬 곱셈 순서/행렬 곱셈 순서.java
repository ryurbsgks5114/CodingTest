import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] dp = new int[N + 1][N + 1];
        int[] matrix = new int[N + 1];

        int r, c;

        for (int i = 1; i <= N; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            r = Integer.parseInt(stringTokenizer.nextToken());
            c = Integer.parseInt(stringTokenizer.nextToken());

            matrix[i - 1] = r;
            matrix[i] = c;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {

                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = dp[i][k] + dp[k + 1][j] + matrix[i - 1] * matrix[k] * matrix[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        bufferedWriter.write(dp[1][N] + "\n");

        bufferedWriter.flush();

    }
}