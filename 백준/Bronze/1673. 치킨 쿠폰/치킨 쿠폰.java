import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {

            StringTokenizer stringTokenizer = new StringTokenizer(line);
            long n = Long.parseLong(stringTokenizer.nextToken());
            long k = Long.parseLong(stringTokenizer.nextToken());
            long total = n;
            long stamp = n;

            while (stamp >= k) {
                long newCoupon = stamp / k;

                total += newCoupon;
                stamp = stamp % k + newCoupon;
            }

            bufferedWriter.write(total + "\n");
        }

        bufferedWriter.flush();

    }
}