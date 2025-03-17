import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] numbers = new int[N + 1];
        int[] prefix = new int[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int k = 0; k < M; k++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            bufferedWriter.write((prefix[j] - prefix[i - 1]) + "\n");
        }

        bufferedWriter.flush();

    }
}