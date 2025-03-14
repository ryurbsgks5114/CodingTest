import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            lines[i] = new Line(a, b);

        }

        Arrays.sort(lines);

        int[] dp = new int[n];
        int len = 1;

        dp[0] = lines[0].b;

        for (int i = 1; i < n; i++) {

            int b = lines[i].b;

            if (b > dp[len - 1]) {
                dp[len++] = b;
            } else {

                int idx = lowerBound(dp, 0, len, b);

                dp[idx] = b;
            }
        }

        bufferedWriter.write((n - len) + "\n");

        bufferedWriter.flush();

    }

    public static int lowerBound(int[] arr, int start, int end, int target) {
        while (start < end) {

            int mid = (start + end) / 2;

            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    static class Line implements Comparable<Line> {

        int a, b;

        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line other) {
            return this.a - other.a;
        }
    }
}