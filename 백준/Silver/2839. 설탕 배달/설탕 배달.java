import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int count = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                count = count + N / 5;
                bufferedWriter.write(String.valueOf(count));
                bufferedWriter.flush();

                return;
            }

            N = N - 3;
            count++;

        }

        bufferedWriter.write("-1");
        bufferedWriter.flush();

    }
}