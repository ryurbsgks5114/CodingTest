import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static long dist2(Point a, Point b) {

        long dx = a.x - b.x;
        long dy = a.y - b.y;

        return dx * dx + dy * dy;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Point[] p = new Point[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            p[i] = new Point(x, y);
        }

        long cross = (long)(p[1].x - p[0].x) * (p[2].y - p[0].y) - (long)(p[1].y - p[0].y) * (p[2].x - p[0].x);

        if (cross == 0) {
            bufferedWriter.write("X\n");
            bufferedWriter.flush();

            return;
        }

        long[] d = new long[3];
        d[0] = dist2(p[0], p[1]);
        d[1] = dist2(p[1], p[2]);
        d[2] = dist2(p[2], p[0]);
        Arrays.sort(d);

        long a2 = d[0], b2 = d[1], c2 = d[2];

        String result;

        if (a2 == b2 && b2 == c2) {
            result = "JungTriangle";
        } else if (a2 == b2 || b2 == c2 || a2 == c2) {
            if (a2 + b2 < c2) {
                result = "Dunkak2Triangle";
            } else if (a2 + b2 == c2) {
                result = "Jikkak2Triangle";
            } else {
                result = "Yeahkak2Triangle";
            }
        } else {
            if (a2 + b2 < c2) {
                result = "DunkakTriangle";
            } else if (a2 + b2 == c2) {
                result = "JikkakTriangle";
            } else {
                result = "YeahkakTriangle";
            }
        }

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}