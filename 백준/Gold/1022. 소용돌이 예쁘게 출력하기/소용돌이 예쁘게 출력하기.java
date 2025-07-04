import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = bufferedReader.readLine().split(" ");
        int r1 = Integer.parseInt(parts[0]);
        int c1 = Integer.parseInt(parts[1]);
        int r2 = Integer.parseInt(parts[2]);
        int c2 = Integer.parseInt(parts[3]);
        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;
        long[][] result = new long[rows][cols];
        long maxVal = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                long v = getValue(r1 + i, c1 + j);

                result[i][j] = v;
                maxVal = Math.max(maxVal, v);
            }
        }

        int width = Long.toString(maxVal).length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String s = Long.toString(result[i][j]);

                for (int k = s.length(); k < width; k++) {
                    bufferedWriter.write(" ");
                }

                bufferedWriter.write(s);

                if (j < cols - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.write("\n");
        }

        bufferedWriter.flush();

    }

    static long getValue(int x, int y) {

        int layer = Math.max(Math.abs(x), Math.abs(y));
        long maxNum = (long) (2 * layer + 1) * (2 * layer + 1);

        if (x == layer) {
            return maxNum - (layer - y);
        } else if (y == -layer) {
            return maxNum - (2 * layer) - (layer - x);
        } else if (x == -layer) {
            return maxNum - (4 * layer) - (y + layer);
        } else {
            return maxNum - (6 * layer) - (x + layer);
        }
    }
}