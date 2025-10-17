import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(bufferedReader.readLine());
        int count = 0;

        for (long i = 1; ; i++) {
            long temp = N - i * (i - 1) / 2;

            if (temp <= 0) {
                break;
            }

            if (temp % i == 0) {
                count++;
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }
}