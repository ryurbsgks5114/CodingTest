import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger n = new BigInteger(bufferedReader.readLine());
        BigInteger low = BigInteger.ZERO;
        BigInteger high = n;
        BigInteger ans = BigInteger.ZERO;

        while (low.compareTo(high) <= 0) {
            BigInteger mid = low.add(high).divide(BigInteger.TWO);
            BigInteger sq = mid.multiply(mid);

            if (sq.compareTo(n) < 0) { 
                low = mid.add(BigInteger.ONE);
            } else {                   
                ans = mid;
                high = mid.subtract(BigInteger.ONE);
            }
        }

        bufferedWriter.write(ans.toString());

        bufferedWriter.flush();

    }
}