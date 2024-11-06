import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Integer[] baskets = new Integer[N];

        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {

            String[] newInput = bufferedReader.readLine().split(" ");
            int I = Integer.parseInt(newInput[0]) - 1;
            int J = Integer.parseInt(newInput[1]) - 1;

            while (I < J) {

                Integer temp = baskets[I];
                baskets[I] = baskets[J];
                baskets[J] = temp;
                I++;
                J--;

            }

        }

        for (Integer el: baskets) {
            bufferedWriter.write(el + " ");
        }

        bufferedWriter.flush();

    }
}