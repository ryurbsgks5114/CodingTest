import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        if (N == 1) {
            bufferedWriter.write("1");
            bufferedWriter.flush();

            return;
        }

        int mod = 15746;
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        bufferedWriter.write(String.valueOf(dp[N]));

        bufferedWriter.flush();

    }
}