import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = bufferedReader.readLine().split(" ");
        String[] secondInput = bufferedReader.readLine().split(" ");

        int N = Integer.parseInt(firstInput[0]);
        int M = Integer.parseInt(firstInput[1]);

        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(secondInput[i]);
        }

        int maxSum = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {

                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum <= M && sum > maxSum) {
                        maxSum = sum;
                    }

                }
            }
        }

        bufferedWriter.write(String.valueOf(maxSum));

        bufferedWriter.flush();

    }
}