import java.io.*;

public class Main {

    static char[][] video;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        video = new char[N][N];

        for (int i = 0; i < N; i++) {
            video[i] = bufferedReader.readLine().toCharArray();
        }

        compress(0, 0, N);

        bufferedWriter.write(result.toString());

        bufferedWriter.flush();

    }

    static void compress(int x, int y, int size) {
        if (isUniform(x, y, size)) {
            result.append(video[x][y]);

            return;
        }

        result.append("(");

        int newSize = size / 2;

        compress(x, y, newSize);
        compress(x, y + newSize, newSize);
        compress(x + newSize, y, newSize);
        compress(x + newSize, y + newSize, newSize);

        result.append(")");
    }

    static boolean isUniform(int x, int y, int size) {

        char first = video[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != first) {
                    return false;
                }
            }
        }

        return true;
    }
}