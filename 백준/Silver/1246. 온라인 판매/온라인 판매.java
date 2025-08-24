import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] prices = new int[M];

        for (int i = 0; i < M; i++) {
            prices[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(prices);

        int bestPrice = 0;
        int maxProfit = 0;

        for (int i = 0; i < M; i++) {

            int price = prices[i];
            int buyers = M - i;
            int sellCount = Math.min(N, buyers);
            int profit = price * sellCount;

            if (profit > maxProfit) {
                maxProfit = profit;
                bestPrice = price;
            }
        }

        bufferedWriter.write(bestPrice + " " + maxProfit + "\n");

        bufferedWriter.flush();

    }
}