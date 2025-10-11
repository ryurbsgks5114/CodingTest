import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int pictureCount = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && paper[i][j] == 1) {
                    pictureCount++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        bufferedWriter.write(pictureCount + "\n" + maxArea + "\n");

        bufferedWriter.flush();

    }

    static int bfs(int x, int y) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        int area = 1;

        while (!queue.isEmpty()) {
            
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && paper[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        area++;
                    }
                }
            }
        }

        return area;
    }
}