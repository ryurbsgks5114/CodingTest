import java.io.*;

public class Main {

    static int N, count;
    static int[] queen;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        queen = new int[N];
        count = 0;

        backtracking(0);

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }

    public static void backtracking(int row) {
        if (row == N) {
            count++;

            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queen[row] = col;
                backtracking(row + 1);
            }
        }
    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col || Math.abs(queen[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }
}