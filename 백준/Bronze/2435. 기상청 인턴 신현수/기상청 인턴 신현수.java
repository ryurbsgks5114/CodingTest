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

        int currentSum = 0;

        for (int i = 0; i < K; i++) {
            currentSum += temps[i];
        }

        int maxSum = currentSum;

        for (int i = K; i < N; i++) {
            currentSum += temps[i] - temps[i - K];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        bufferedWriter.write(String.valueOf(maxSum));

        bufferedWriter.flush();

    }
}