import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static int[] dx = { 1, -1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, 1, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());

        box = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        int result = bfs();

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }

    static int bfs() {
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int z = curr[0], x = curr[1], y = curr[2];

            for (int i = 0; i < 6; i++) {

                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nz && nz < H && 0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = box[z][x][y] + 1;
                        queue.offer(new int[]{nz, nx, ny});
                    }
                }
            }
        }

        int days = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }

                    days = Math.max(days, box[i][j][k]);
                }
            }
        }

        return days - 1;
    }
}