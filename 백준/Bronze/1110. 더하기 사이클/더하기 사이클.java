import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int original = N;
        int count = 0;

        do {
            int tens = N / 10;
            int ones = N % 10;
            int sum = tens + ones;

            N = ones * 10 + (sum % 10);
            count++;
        } while (N != original);

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }
}