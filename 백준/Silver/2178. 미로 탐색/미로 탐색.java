import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            String line = bufferedReader.readLine();

            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bufferedWriter.write(maze[N-1][M-1] + "\n");

        bufferedWriter.flush();

    }

    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x, y));

        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            for (int dir = 0; dir < 4; dir++) {

                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[now.x][now.y] + 1;
                    }
                }
            }
        }
    }
}