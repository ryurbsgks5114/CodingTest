import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(bufferedReader.readLine());

        String binary = Long.toBinaryString(N);

        BigInteger answer = new BigInteger(binary, 3);

        bufferedWriter.write(answer.toString());

        bufferedWriter.flush();

    }
}