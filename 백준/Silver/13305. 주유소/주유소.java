import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        long[] roads = new long[N - 1];
        long[] prices = new long[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N - 1; i++) {
            roads[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            prices[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        long totalCost = 0;
        long minPrice = prices[0];

        for (int i = 0; i < N - 1; i++) {
            totalCost += minPrice * roads[i];

            if (prices[i + 1] < minPrice) {
                minPrice = prices[i + 1];
            }
        }

        bufferedWriter.write(String.valueOf(totalCost));

        bufferedWriter.flush();

    }
}