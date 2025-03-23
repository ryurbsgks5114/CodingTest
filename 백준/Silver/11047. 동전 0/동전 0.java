import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] coins = new int[N];
        
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                count += K / coins[i];
                K %= coins[i];
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }
}