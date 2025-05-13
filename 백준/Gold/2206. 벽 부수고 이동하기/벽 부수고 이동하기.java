import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {

            String line = bufferedReader.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bufferedWriter.write(bfs() + "\n");

        bufferedWriter.flush();

    }

    static class Point {

        int x, y, breakWall;

        Point(int x, int y, int breakWall) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
        }
    }

    static int bfs() {

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0, 0));

        visited[0][0][0] = true;

        int steps = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                Point point = queue.poll();

                if (point.x == N - 1 && point.y == M - 1) {
                    return steps;
                }

                for (int d = 0; d < 4; d++) {

                    int nx = point.x + dx[d];
                    int ny = point.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }

                    if (map[nx][ny] == 0 && !visited[nx][ny][point.breakWall]) {
                        visited[nx][ny][point.breakWall] = true;
                        queue.offer(new Point(nx, ny, point.breakWall));
                    }

                    if (map[nx][ny] == 1 && point.breakWall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Point(nx, ny, 1));
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}