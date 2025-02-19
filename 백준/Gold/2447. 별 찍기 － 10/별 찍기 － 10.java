import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        char[][] stars = new char[N][N];

        fillStars(stars, 0, 0, N, false);

        for (int i = 0; i < N; i++) {
            bufferedWriter.write(stars[i]);
            bufferedWriter.write("\n");
        }

        bufferedWriter.flush();

    }

    public static void fillStars(char[][] stars, int x, int y, int size, boolean blank) {
        if (blank) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    stars[i][j] = ' ';
                }
            }

            return;
        }

        if (size == 1) {
            stars[x][y] = '*';

            return;
        }

        int newSize = size / 3;
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                fillStars(stars, x + i * newSize, y + j * newSize, newSize, count == 5);
            }
        }
    }
}