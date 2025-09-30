import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long S = Long.parseLong(stringTokenizer.nextToken());
        long K = Long.parseLong(stringTokenizer.nextToken());
        long q = S / K;
        long r = S % K;
        long result = 1;

        for (int i = 0; i < K - r; i++) {
            result *= q;
        }

        for (int i = 0; i < r; i++) {
            result *= (q + 1);
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();

    }
}