import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        String result = "";

        while (N > 0) {

            int remainder = N % B;

            if (remainder < 10) {
                result = (char) ('0' + remainder) + result;
            } else {
                result = (char) ('A' + (remainder - 10)) + result;
            }

            N /= B;

        }

        bufferedWriter.write(result);

        bufferedWriter.flush();

    }
}