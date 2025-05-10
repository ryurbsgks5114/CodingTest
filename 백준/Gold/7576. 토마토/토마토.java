import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (box[i][j] == 1) {
                    queue.offer(new int[]{ i, j });
                }
            }
        }

        bufferedWriter.write(bfs() + "\n");

        bufferedWriter.flush();

    }

    public static int bfs() {
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = box[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        int days = 0;

        for (int[] el: box) {
            for (int element: el) {
                if (element == 0) {
                    return -1;
                }

                days = Math.max(days, element);
            }
        }

        return days - 1;
    }
}