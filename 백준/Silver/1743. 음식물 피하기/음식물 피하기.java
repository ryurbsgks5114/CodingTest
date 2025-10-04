import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static boolean[][] food;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        food = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            food[r][c] = true;
        }

        int maxSize = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (food[i][j] && !visited[i][j]) {
                    int size = dfs(i, j);

                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        bufferedWriter.write(String.valueOf(maxSize));

        bufferedWriter.flush();

    }

    static int dfs(int r, int c) {

        int size = 1;

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
                if (food[nr][nc] && !visited[nr][nc]) {
                    size += dfs(nr, nc);
                }
            }
        }

        return size;
    }
}