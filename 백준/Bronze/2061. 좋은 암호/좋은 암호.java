import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        BigInteger K = new BigInteger(input[0]);
        int L = Integer.parseInt(input[1]);

        for (int i = 2; i < L; i++) {
            if (K.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                bufferedWriter.write("BAD " + i + "\n");
                bufferedWriter.flush();
                bufferedWriter.close();

                return;
            }
        }

        bufferedWriter.write("GOOD\n");

        bufferedWriter.flush();

    }
}