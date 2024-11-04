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

        for (int i = 0; i < N; i++) {
            basket[i] = i + 1;
        }

        for (int a = 0; a < M; a++) {

            String[] changeBall = bufferedReader.readLine().split(" ");
            int i = Integer.parseInt(changeBall[0]);
            int j = Integer.parseInt(changeBall[1]);

            Integer temp = basket[i - 1];
            basket[i - 1] = basket[j - 1];
            basket[j - 1] = temp;

        }

        String answer = Arrays.stream(basket)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        bufferedWriter.write(answer);

        bufferedWriter.flush();

    }
}