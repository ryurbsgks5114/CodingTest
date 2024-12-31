import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] count = new int[10001];

        for (int i = 0; i < N; i++) {

            int number = Integer.parseInt(bufferedReader.readLine());

            count[number]++;

        }

        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                bufferedWriter.write(String.valueOf(i));
                bufferedWriter.newLine();
                count[i]--;
            }
        }

        bufferedWriter.flush();

    }
}