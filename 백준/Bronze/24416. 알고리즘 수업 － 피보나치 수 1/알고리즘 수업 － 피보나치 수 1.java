import java.io.*;

public class Main {

    static int[] dp;
    static int count = 0;
    static int dpCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        dp = new int[n + 1];

        fibRecursive(n);
        fibonacciDP(n);

        bufferedWriter.write(count + " " + dpCount + "\n");

        bufferedWriter.flush();

    }

    public static int fibRecursive(int n) {
        if (n == 1 || n == 2) {
            count++;

            return 1;
        }

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void fibonacciDP(int n) {
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dpCount++;
        }
    }
}