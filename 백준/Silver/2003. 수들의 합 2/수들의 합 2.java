import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] arr = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = arr[0];
        int count = 0;

        while (true) {
            if (sum == M) {
                count++;
            }

            if (sum >= M) {
                sum -= arr[start++];
            } else {
                end++;

                if (end == N) {
                    break;
                }

                sum += arr[end];
            }

            if (start == N) {
                break;
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }
}