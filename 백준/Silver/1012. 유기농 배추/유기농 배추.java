import java.io.*;
import java.util.*;

public class Main {

    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            field = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());

                field[y][x] = 1;
            }

            int wormCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        wormCount++;
                    }
                }
            }

            bufferedWriter.write(wormCount + "\n");

        }

        bufferedWriter.flush();

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (!visited[nx][ny] && field[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}