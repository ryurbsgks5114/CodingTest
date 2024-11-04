import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Integer[] basket = new Integer[N];
        Arrays.fill(basket, 0);

        for (int a = 0; a < M; a++) {

            String[] insertBall = bufferedReader.readLine().split(" ");
            int i = Integer.parseInt(insertBall[0]);
            int j = Integer.parseInt(insertBall[1]);
            int k = Integer.parseInt(insertBall[2]);

            for (int b = i - 1; b < j; b++) {
                basket[b] = k;
            }

        }

        String answer = Arrays.stream(basket)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        bufferedWriter.write(answer);

        bufferedWriter.flush();

    }
}