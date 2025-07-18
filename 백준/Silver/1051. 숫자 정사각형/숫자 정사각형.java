import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        char[][] grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int maxSize = 1;
        int maxLen = Math.min(N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; k < maxLen; k++) {
                    
                    int ni = i + k;
                    int nj = j + k;
                    
                    if (ni >= N || nj >= M) {
                        break;
                    }
                    
                    if (grid[i][j] == grid[i][nj] && grid[i][j] == grid[ni][j] && grid[i][j] == grid[ni][nj]) {
                        maxSize = Math.max(maxSize, k + 1);
                    }
                }
            }
        }

        bufferedWriter.write((maxSize * maxSize) + "\n");

        bufferedWriter.flush();

    }
}