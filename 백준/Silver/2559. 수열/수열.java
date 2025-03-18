import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] temps = new int[N];
        
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        for (int i = 0; i < N; i++) {
            temps[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int sum = 0;

        for (int i = 0; i < K; i++) {
            sum += temps[i];
        }

        int maxSum = sum;
        
        for (int i = K; i < N; i++) {
            sum = sum - temps[i - K] + temps[i];
            maxSum = Math.max(maxSum, sum);
        }

        bufferedWriter.write(String.valueOf(maxSum));

        bufferedWriter.flush();

    }
}