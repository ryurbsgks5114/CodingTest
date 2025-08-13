import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int S1 = Integer.parseInt(stringTokenizer.nextToken());
        int S2 = Integer.parseInt(stringTokenizer.nextToken());
        int S3 = Integer.parseInt(stringTokenizer.nextToken());

        int maxSum = S1 + S2 + S3;
        int[] freq = new int[maxSum + 1];

        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    freq[i + j + k]++;
                }
            }
        }

        int bestSum = 3;
        int bestCnt = freq[3];

        for (int i = 4; i <= maxSum; i++) {
            if (freq[i] > bestCnt) {
                bestCnt = freq[i];
                bestSum = i;
            }
        }

        bufferedWriter.write(String.valueOf(bestSum));

        bufferedWriter.flush();

    }
}