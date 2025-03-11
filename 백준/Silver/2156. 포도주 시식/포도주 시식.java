import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] wine = new int[n + 1];
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(bufferedReader.readLine());
        }

        dp[1] = wine[1];

        if (n >= 2) {
            dp[2] = wine[1] + wine[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        bufferedWriter.write(dp[n] + "\n");

        bufferedWriter.flush();

    }
}