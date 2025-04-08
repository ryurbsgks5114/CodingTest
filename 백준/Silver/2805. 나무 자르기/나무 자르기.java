import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        long M = Long.parseLong(stringTokenizer.nextToken());

        int[] trees = new int[N];
        int max = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(stringTokenizer.nextToken());

            if (trees[i] > max) {
                max = trees[i];
            }
        }

        int left = 0;
        int right = max;
        int answer = 0;

        while (left <= right) {

            int mid = (left + right) / 2;
            long sum = 0;

            for (int el: trees) {
                if (el > mid) {
                    sum += (el - mid);
                }
            }

            if (sum >= M) {
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