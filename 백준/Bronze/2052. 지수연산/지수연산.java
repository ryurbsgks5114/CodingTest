import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        BigDecimal numerator = BigDecimal.ONE;
        BigDecimal denominator = BigDecimal.valueOf(2).pow(N);
        BigDecimal result = numerator.divide(denominator, N + 5, RoundingMode.UNNECESSARY);

        result = result.stripTrailingZeros();

        bufferedWriter.write(result.toPlainString());

        bufferedWriter.flush();

    }
}