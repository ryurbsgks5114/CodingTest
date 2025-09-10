import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        char[][] map = new char[M][N];

        for (int i = 0; i < M; i++) {
            String line = bufferedReader.readLine().trim();
            map[i] = line.toCharArray();
        }

        boolean[][] visited = new boolean[M][N];
        long white = 0;
        long blue = 0;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {

                    char color = map[i][j];
                    int count = 0;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {

                        int[] cur = q.poll();
                        count++;
                        int cr = cur[0];
                        int cc = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int nr = cr + dr[k];
                            int nc = cc + dc[k];

                            if (nr < 0 || nr >= M || nc < 0 || nc >= N) {
                                continue;
                            }

                            if (visited[nr][nc]) {
                                continue;
                            }

                            if (map[nr][nc] != color) {
                                continue;
                            }

                            visited[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }

                    long power = 1L * count * count;

                    if (color == 'W') {
                        white += power;
                    } else {
                        blue += power;
                    }
                }
            }
        }

        bufferedWriter.write(white + " " + blue + "\n");

        bufferedWriter.flush();

    }
}