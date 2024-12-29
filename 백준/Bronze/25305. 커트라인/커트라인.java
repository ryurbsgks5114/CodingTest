import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] scores = new int[N];
        String[] newInput = bufferedReader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(newInput[i]);
        }

        Arrays.sort(scores);

        int cutLine = scores[N - k];

        bufferedWriter.write(String.valueOf(cutLine));

        bufferedWriter.flush();

    }
}