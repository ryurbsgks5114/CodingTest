import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = bufferedReader.readLine().toCharArray();
        }

        int minPaint = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {

                int paintW = countPaint(board, i, j, 'W');
                int paintB = countPaint(board, i, j, 'B');

                minPaint = Math.min(minPaint, Math.min(paintW, paintB));

            }
        }

        bufferedWriter.write(String.valueOf(minPaint));
        bufferedWriter.flush();

    }

    private static int countPaint(char[][] board, int X, int Y, char firstColor) {

        int count = 0;
        char color = firstColor;

        for (int i = X; i < X + 8; i++) {
            for (int j = Y; j < Y + 8; j++) {
                if (board[i][j] != color) {
                    count++;
                }

                color = (color == 'W') ? 'B' : 'W';
            }

            color = (color == 'W') ? 'B' : 'W';
        }

        return count;
    }
}