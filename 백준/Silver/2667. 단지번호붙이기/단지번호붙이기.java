import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {

            String line = bufferedReader.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {

                    int houseCount = dfs(i, j);

                    result.add(houseCount);
                }
            }
        }

        Collections.sort(result);
        bufferedWriter.write(result.size() + "\n");

        for (int el: result) {
            bufferedWriter.write(el + "\n");
        }

        bufferedWriter.flush();

    }

    static int dfs(int x, int y) {

        int count = 1;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }
}