import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        BigInteger a = new BigInteger(input[0], 2);
        BigInteger b = new BigInteger(input[1], 2);

        BigInteger sum = a.add(b);

        bufferedWriter.write(sum.toString(2) + "\n");

        bufferedWriter.flush();

    }
}