import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {

            int sum = i;
            int temp = i;

            while (temp > 0) {
                sum = sum + temp % 10;
                temp = temp / 10;
            }

            if (sum == N) {
                result = i;

                break;
            }

        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();

    }
}