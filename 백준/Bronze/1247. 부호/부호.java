import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {

            int N = Integer.parseInt(bufferedReader.readLine());
            BigInteger sum = BigInteger.ZERO;

            for (int j = 0; j < N; j++) {
                BigInteger num = new BigInteger(bufferedReader.readLine());
                sum = sum.add(num);
            }

            int sign = sum.signum();

            if (sign > 0) {
                bufferedWriter.write("+\n");
            } else if (sign < 0) {
                bufferedWriter.write("-\n");
            } else {
                bufferedWriter.write("0\n");
            }
        }

        bufferedWriter.flush();

    }
}