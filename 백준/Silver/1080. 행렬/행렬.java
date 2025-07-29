import java.io.*;

public class Main {

    static int N, M;
    static int[][] A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();

            for (int j = 0; j < M; j++) {
                A[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();

            for (int j = 0; j < M; j++) {
                B[i][j] = row.charAt(j) - '0';
            }
        }

        int result = solve();
        
        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }

    public static int solve() {
        int count = 0;

        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip3x3(i, j);
                    count++;
                }
            }
        }

        if (!isSame()) {
            return -1;
        }

        return count;
    }

    public static void flip3x3(int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                A[i][j] ^= 1; // 0 -> 1, 1 -> 0
            }
        }
    }

    public static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}