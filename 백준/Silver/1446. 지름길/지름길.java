import java.io.*;
import java.util.*;

public class Main {

    static class Road {

        int start;
        int end;
        int dist;

        Road(int s, int e, int d) {
            this.start = s;
            this.end = e;
            this.dist = d;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int D = Integer.parseInt(stringTokenizer.nextToken());

        List<Road> roads = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int dist = Integer.parseInt(stringTokenizer.nextToken());

            if (end > D || end - start <= dist) {
                continue;
            }

            roads.add(new Road(start, end, dist));
        }

        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            for (Road el: roads) {
                if (el.start == i && el.end <= D) {
                    dp[el.end] = Math.min(dp[el.end], dp[i] + el.dist);
                }
            }
        }

        bufferedWriter.write(dp[D] + "\n");

        bufferedWriter.flush();

    }
}