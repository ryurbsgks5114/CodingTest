import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int C = Integer.parseInt(first[1]);
        int W = Integer.parseInt(first[2]);

        int[] trees = new int[N];
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(bufferedReader.readLine());
            maxLen = Math.max(maxLen, trees[i]);
        }

        long answer = 0;

        for (int i = 1; i <= maxLen; i++) {
            long total = 0;

            for (int el: trees) {
                int pieces = el / i;

                if (pieces == 0) {
                    continue;
                }

                int cutCount = (el % i == 0 ? pieces - 1 : pieces);
                long profit = (long) pieces * i * W - (long) cutCount * C;

                if (profit > 0) {
                    total += profit;
                }
            }

            answer = Math.max(answer, total);
        }

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();

    }
}