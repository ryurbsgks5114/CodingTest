import java.io.*;
import java.util.*;

public class Main {

    static class Pair {

        int index;
        long value;

        Pair(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int D = Integer.parseInt(stringTokenizer.nextToken());

        long[] K = new long[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            K[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        long[] dp = new long[N];

        Deque<Pair> deque = new ArrayDeque<>();

        dp[0] = K[0];

        deque.add(new Pair(0, dp[0]));

        long result = dp[0];

        for (int i = 1; i < N; i++) {
            while (!deque.isEmpty() && deque.peekFirst().index < i - D) {
                deque.pollFirst();
            }

            long maxPrev = deque.isEmpty() ? 0 : Math.max(0, deque.peekFirst().value);

            dp[i] = K[i] + maxPrev;
            result = Math.max(result, dp[i]);

            while (!deque.isEmpty() && deque.peekLast().value <= dp[i]) {
                deque.pollLast();
            }

            deque.addLast(new Pair(i, dp[i]));
        }

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}