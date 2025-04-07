import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int K = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[] cables = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(bufferedReader.readLine());

            if (cables[i] > max) {
                max = cables[i];
            }
        }

        long left = 1;
        long right = max;
        long answer = 0;

        while (left <= right) {

            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += cables[i] / mid;
            }

            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bufferedWriter.write(answer + "\n");

        bufferedWriter.flush();

    }
}