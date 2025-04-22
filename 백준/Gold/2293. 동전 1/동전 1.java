import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int el: coins) {
            for (int i = el; i <= k; i++) {
                dp[i] += dp[i - el];
            }
        }

        bufferedWriter.write(dp[k] + "\n");

        bufferedWriter.flush();

    }
}