import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());

        int[] arr = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];

            while(sum >= S) {
                minLen = Math.min(minLen, i - start + 1);
                sum -= arr[start++];
            }
        }

        bufferedWriter.write((minLen == Integer.MAX_VALUE ? 0 : minLen) + "\n");

        bufferedWriter.flush();

    }
}