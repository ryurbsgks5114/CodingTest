import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        BigInteger n = new BigInteger(stringTokenizer.nextToken());
        BigInteger m = new BigInteger(stringTokenizer.nextToken());

        BigInteger quotient = n.divide(m);
        BigInteger remainder = n.remainder(m);

        bufferedWriter.write(quotient.toString());
        bufferedWriter.newLine();
        bufferedWriter.write(remainder.toString());

        bufferedWriter.flush();

    }
}