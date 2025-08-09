import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int newScore = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());
        int[] scores = new int[N];

        if (N > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        if (N == 0) {
            bufferedWriter.write("1\n");
            bufferedWriter.flush();

            return;
        }

        if (N == P && newScore <= scores[N - 1]) {
            bufferedWriter.write("-1\n");
            bufferedWriter.flush();

            return;
        }

        int rank = 1;

        for (int i = 0; i < N; i++) {
            if (scores[i] > newScore) {
                rank++;
            } else {
                break;
            }
        }

        bufferedWriter.write(rank + "\n");

        bufferedWriter.flush();

    }
}