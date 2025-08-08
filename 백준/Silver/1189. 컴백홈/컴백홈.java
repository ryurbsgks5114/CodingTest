import java.io.*;
import java.util.*;

public class Main {

    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = bufferedReader.readLine();
            
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[R][C];

        if (map[R - 1][0] != 'T') {
            visited[R - 1][0] = true;
            dfs(R - 1, 0, 1);
            visited[R - 1][0] = false;
        }

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();

    }

    static void dfs(int r, int c, int dist) {
        if (r == 0 && c == C - 1) {
            if (dist == K) {
                answer++;
            }

            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

            if (map[nr][nc] == 'T') {
                continue;
            }

            if (dist + 1 > K) {
                continue;
            }

            visited[nr][nc] = true;
            dfs(nr, nc, dist + 1);
            visited[nr][nc] = false;
        }
    }
}