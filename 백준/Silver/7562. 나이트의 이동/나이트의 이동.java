import java.io.*;
import java.util.*;

public class Main {

    static int l;
    static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            l = Integer.parseInt(bufferedReader.readLine());

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sx = Integer.parseInt(stringTokenizer.nextToken());
            int sy = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int ex = Integer.parseInt(stringTokenizer.nextToken());
            int ey = Integer.parseInt(stringTokenizer.nextToken());

            bufferedWriter.write(bfs(sx, sy, ex, ey) + "\n");
        }

        bufferedWriter.flush();

    }

    static class Point {

        int x, y, dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int bfs(int sx, int sy, int ex, int ey) {

        boolean[][] visited = new boolean[l][l];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(sx, sy, 0));

        visited[sx][sy] = true;

        while (!queue.isEmpty()) {

            Point p = queue.poll();

            if (p.x == ex && p.y == ey) {
                return p.dist;
            }

            for (int i = 0; i < 8; i++) {

                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, p.dist + 1));
                }
            }
        }

        return 0;
    }
}