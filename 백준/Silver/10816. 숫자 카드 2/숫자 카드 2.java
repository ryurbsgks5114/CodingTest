import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] cards = bufferedReader.readLine().split(" ");

        Map<Integer, Integer> cardCount = new HashMap<>();

        for (String card: cards) {

            int number = Integer.parseInt(card);

            cardCount.put(number, cardCount.getOrDefault(number, 0) + 1);

        }

        int M = Integer.parseInt(bufferedReader.readLine());

        String[] input = bufferedReader.readLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (String el: input) {

            int number = Integer.parseInt(el);

            result.append(cardCount.getOrDefault(number, 0)).append(" ");

        }

        bufferedWriter.write(result.toString().trim());

        bufferedWriter.flush();

    }
}