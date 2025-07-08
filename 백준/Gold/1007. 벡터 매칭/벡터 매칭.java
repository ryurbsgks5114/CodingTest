import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Point[] points;
    static boolean[] visited;
    static double min;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(bufferedReader.readLine());
            points = new Point[N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());

                points[i] = new Point(x, y);
            }

            min = Double.MAX_VALUE;
            dfs(0, 0);
            bufferedWriter.write(String.format("%.12f\n", min));
        }

        bufferedWriter.flush();

    }

    static void dfs(int depth, int idx) {
        if (depth == N / 2) {
            long vx = 0;
            long vy = 0;

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    vx += points[i].x;
                    vy += points[i].y;
                } else {
                    vx -= points[i].x;
                    vy -= points[i].y;
                }
            }

            double len = Math.sqrt(vx * vx + vy * vy);

            min = Math.min(min, len);

            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}