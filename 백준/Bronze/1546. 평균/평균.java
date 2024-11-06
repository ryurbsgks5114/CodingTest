import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] input = bufferedReader.readLine().split(" ");

        double[] scores = new double[N];
        double maxScore = 0.0;

        for (int i = 0; i < N; i++) {

            scores[i] = Double.parseDouble(input[i]);

            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }

        }

        double total = 0.0;

        for (int i = 0; i < N; i++) {
            total = total + (scores[i] / maxScore) * 100;
        }

        double average = total / N;

        bufferedWriter.write(String.valueOf(average));

        bufferedWriter.flush();

    }
}