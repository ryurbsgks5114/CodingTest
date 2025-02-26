import java.io.*;

public class Main {

    static int[][] board = new int[9][9];
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {

            String[] input = bufferedReader.readLine().split(" ");

            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        solveSudoku(0, 0);

        bufferedWriter.flush();

    }

    public static boolean solveSudoku(int row, int col) throws IOException {
        if (col == 9) {
            return solveSudoku(row + 1, 0);
        }

        if (row == 9) {
            printBoard();

            return true;
        }

        if (board[row][col] != 0) {
            return solveSudoku(row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;

                if (solveSudoku(row, col + 1)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard() throws IOException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bufferedWriter.write(board[i][j] + " ");
            }

            bufferedWriter.write("\n");
        }
    }
}