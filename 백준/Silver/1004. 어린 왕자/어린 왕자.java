import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] planets = new int[n][3];

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                planets[i][0] = Integer.parseInt(stringTokenizer.nextToken());
                planets[i][1] = Integer.parseInt(stringTokenizer.nextToken());
                planets[i][2] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int result = countCrossings(x1, y1, x2, y2, planets);

            bufferedWriter.write(result + "\n");
        }

        bufferedWriter.flush();

    }

    static int countCrossings(int x1, int y1, int x2, int y2, int[][] planets) {
        int count = 0;

        for (int[] el: planets) {

            int cx = el[0];
            int cy = el[1];
            int r = el[2];
            boolean startInside = isInside(x1, y1, cx, cy, r);
            boolean endInside = isInside(x2, y2, cx, cy, r);

            if (startInside != endInside) {
                count++;
            }
        }

        return count;
    }

    static boolean isInside(int x, int y, int cx, int cy, int r) {

        int dx = x - cx;
        int dy = y - cy;

        return dx * dx + dy * dy < r * r;
    }
}