import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int white = 0;
    static int blue = 0;

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

        bufferedWriter.write(white+ "\n");
        bufferedWriter.write(blue+ "\n");

        bufferedWriter.flush();

    }

    static void divide(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        int newSize = size / 2;

        divide(x, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y, newSize);
        divide(x + newSize, y + newSize, newSize);
    }

    static boolean isSameColor(int x, int y, int size) {

        int color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}