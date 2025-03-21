import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] prefix = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 1; j <= N; j++) {

                int num = Integer.parseInt(stringTokenizer.nextToken());

                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + num;

            }
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            int sum = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];

            bufferedWriter.write(sum + "\n");
        }

        bufferedWriter.flush();

    }
}