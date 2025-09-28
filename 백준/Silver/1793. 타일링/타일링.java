import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= 250; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }

        String line;

        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            int n = Integer.parseInt(line.trim());

            bufferedWriter.write(dp[n].toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}