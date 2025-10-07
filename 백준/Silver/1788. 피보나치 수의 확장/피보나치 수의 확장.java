import java.io.*;

public class Main {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        if (n == 0) {
            bufferedWriter.write("0\n0\n");
        } else {

            int sign = 1;
            int absN = Math.abs(n);

            int[] fib = new int[absN + 1];
            fib[0] = 0;
            fib[1] = 1;

            for (int i = 2; i <= absN; i++) {
                fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
            }

            int result = fib[absN];

            if (n < 0 && (absN % 2 == 0)) {
                sign = -1;
            }

            bufferedWriter.write(sign + "\n");
            bufferedWriter.write(result + "\n");
        }

        bufferedWriter.flush();

    }
}