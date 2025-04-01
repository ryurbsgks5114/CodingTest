import java.io.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long[] factorial = new long[N + 1];

        factorial[0] = 1;

        for (int i = 1; i <= N; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long numerator = factorial[N];
        long denominator = (factorial[K] * factorial[N - K]) % MOD;
        long denominatorInverse = power(denominator, MOD - 2);
        long result = (numerator * denominatorInverse) % MOD;

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();

    }

    static long power(long base, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = power(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        
        return result;
    }
}