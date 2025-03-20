import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] modCount = new int[M];
        long count = 0;
        long prefixSum = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(stringTokenizer.nextToken());

            prefixSum += num;

            int mod = (int)(prefixSum % M);

            if (mod == 0) {
                count++;
            }

            modCount[mod]++;
        }

        for (int i = 0; i < M; i++) {
            if (modCount[i] >= 2) {
                count += (long) modCount[i] * (modCount[i] - 1) / 2;
            }
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }
}