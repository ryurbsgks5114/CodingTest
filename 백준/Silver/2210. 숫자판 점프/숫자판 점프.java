import java.io.*;
import java.util.*;

public class Main {

    static int[][] board = new int[5][5];
    static Set<String> set = new HashSet<>();
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, String.valueOf(board[i][j]));
            }
        }

        bufferedWriter.write(set.size() + "\n");

        bufferedWriter.flush();

    }

    static void dfs(int x, int y, int depth, String number) {
        if (depth == 5) {
            set.add(number);

            return;
        }

        for (int dir = 0; dir < 4; dir++) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                dfs(nx, ny, depth + 1, number + board[nx][ny]);
            }
        }
    }
}