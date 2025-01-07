import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] cards = bufferedReader.readLine().split(" ");

        Set<Integer> cardSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            cardSet.add(Integer.parseInt(cards[i]));
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        String[] checkCards = bufferedReader.readLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < M; i++) {

            int number = Integer.parseInt(checkCards[i]);

            if (cardSet.contains(number)) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }

        bufferedWriter.write(result.toString().trim());

        bufferedWriter.flush();

    }
}