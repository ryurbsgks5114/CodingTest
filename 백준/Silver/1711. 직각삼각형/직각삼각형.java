import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            long x = Long.parseLong(stringTokenizer.nextToken());
            long y = Long.parseLong(stringTokenizer.nextToken());

            points[i] = new Point(x, y);
        }

        long answer = 0;

        for (int i = 0; i < N; i++) {
            Map<String, Integer> map = new HashMap<>();
            Point p = points[i];

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                long dx = points[j].x - p.x;
                long dy = points[j].y - p.y;
                long g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;

                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                String key = dx + "," + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (String el: map.keySet()) {
                String[] parts = el.split(",");
                long dx = Long.parseLong(parts[0]);
                long dy = Long.parseLong(parts[1]);
                long ndx = dy;
                long ndy = -dx;

                if (ndx < 0 || (ndx == 0 && ndy < 0)) {
                    ndx = -ndx;
                    ndy = -ndy;
                }

                String ortho = ndx + "," + ndy;

                if (map.containsKey(ortho)) {
                    answer += (long) map.get(el) * map.get(ortho);
                }
            }
        }

        answer /= 2;

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();

    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;

            a = b;
            b = t;
        }

        return a;
    }
}