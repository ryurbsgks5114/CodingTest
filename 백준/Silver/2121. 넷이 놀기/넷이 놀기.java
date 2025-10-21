import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());

        HashSet<Long> set = new HashSet<>(N * 2);
        long[] xs = new long[N];
        long[] ys = new long[N];

        for (int i = 0; i < N; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            xs[i] = x;
            ys[i] = y;

            long key = (((long) x) << 32) ^ (y & 0xffffffffL);
            set.add(key);

        }

        long count = 0;

        for (int i = 0; i < N; i++) {

            long x = xs[i];
            long y = ys[i];
            long k1 = (((long)(x + A)) << 32) ^ ((y) & 0xffffffffL);
            long k2 = (((long)(x)) << 32) ^ ((y + B) & 0xffffffffL);
            long k3 = (((long)(x + A)) << 32) ^ ((y + B) & 0xffffffffL);

            if (set.contains(k1) && set.contains(k2) && set.contains(k3)) {
                count++;
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }
}