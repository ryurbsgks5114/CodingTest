import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] stair = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(bufferedReader.readLine());
        }

        if (n == 1) {
            bufferedWriter.write(stair[0] + "\n");
            bufferedWriter.flush();

            return;
        }

        dp[0] = stair[0];
        dp[1] = stair[0] + stair[1];

        if (n > 2) {
            dp[2] = Math.max(stair[0], stair[1]) + stair[2];

            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
            }
        }

        bufferedWriter.write(dp[n - 1] + "\n");

        bufferedWriter.flush();

    }
}