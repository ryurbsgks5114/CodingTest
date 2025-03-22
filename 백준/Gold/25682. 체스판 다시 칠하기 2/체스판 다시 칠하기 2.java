import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        char[][] board = new char[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String row = bufferedReader.readLine();

            for (int j = 1; j <= M; j++) {
                board[i][j] = row.charAt(j - 1);
            }
        }

        int[][] diffW = new int[N + 1][M + 1];
        int[][] diffB = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                diffW[i][j] = diffW[i - 1][j] + diffW[i][j - 1] - diffW[i - 1][j - 1];
                diffB[i][j] = diffB[i - 1][j] + diffB[i][j - 1] - diffB[i - 1][j - 1];

                if (board[i][j] != expectedW) {
                    diffW[i][j]++;
                }

                if (board[i][j] != expectedB) {
                    diffB[i][j]++;
                }
            }
        }

        int minChange = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {

                int countW = getAreaSum(diffW, i - K + 1, j - K + 1, i, j);
                int countB = getAreaSum(diffB, i - K + 1, j - K + 1, i, j);

                minChange = Math.min(minChange, Math.min(countW, countB));
            }
        }

        bufferedWriter.write(minChange + "\n");

        bufferedWriter.flush();

    }

    static int getAreaSum(int[][] prefix, int x1, int y1, int x2, int y2) {
        return prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
    }
}