import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long[] files = new long[N];

        for (int i = 0; i < N; i++) {
            files[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        long cluster = Long.parseLong(bufferedReader.readLine());
        long total = 0;

        for (int i = 0; i < N; i++) {
            if (files[i] == 0) {
                continue;
            }

            long clustersNeeded = (files[i] + cluster - 1) / cluster;

            total += clustersNeeded * cluster;
        }

        bufferedWriter.write(String.valueOf(total));

        bufferedWriter.flush();

    }
}