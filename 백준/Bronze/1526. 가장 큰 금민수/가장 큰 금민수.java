import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> luckyNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        generateLucky(0);

        Collections.sort(luckyNumbers);

        int answer = 0;

        for (int el: luckyNumbers) {
            if (el <= N) {
                answer = el;
            }
        }

        bufferedWriter.write(answer + "\n");

        bufferedWriter.flush();

    }

    static void generateLucky(int current) {
        if (current > 1_000_000) {
            return;
        }

        if (current != 0) {
            luckyNumbers.add(current);
        }

        generateLucky(current * 10 + 4);
        generateLucky(current * 10 + 7);
    }
}