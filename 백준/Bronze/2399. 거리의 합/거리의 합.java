import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        long[] x = new long[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            x[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        Arrays.sort(x);

        long total = 0;
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            total += x[i] * i - prefixSum;
            prefixSum += x[i];
        }

        total *= 2;

        bufferedWriter.write(total + "\n");

        bufferedWriter.flush();

    }
}