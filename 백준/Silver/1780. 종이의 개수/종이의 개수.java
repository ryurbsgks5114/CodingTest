import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int countMinusOne = 0;
    static int countZero = 0;
    static int countOne = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        divide(0, 0, N);

        bufferedWriter.write(countMinusOne + "\n");
        bufferedWriter.write(countZero + "\n");
        bufferedWriter.write(countOne + "\n");

        bufferedWriter.flush();

    }

    static void divide(int x, int y, int size) {
        if (isUniform(x, y, size)) {
            if (paper[x][y] == -1) {
                countMinusOne++;
            } else if (paper[x][y] == 0) {
                countZero++;
            } else {
                countOne++;
            }

            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    static boolean isUniform(int x, int y, int size) {

        int first = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != first) {
                    return false;
                }
            }
        }

        return true;
    }
}