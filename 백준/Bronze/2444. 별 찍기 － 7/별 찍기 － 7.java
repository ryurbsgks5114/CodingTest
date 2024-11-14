import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {

            for (int j = 0; j < N - i; j++) {
                bufferedWriter.write(" ");
            }

            for (int j = 0; j < (2 * i - 1); j++) {
                bufferedWriter.write("*");
            }

            bufferedWriter.newLine();

        }

        for (int i = N - 1; i >= 1; i--) {

            for (int j = 0; j < N - i; j++) {
                bufferedWriter.write(" ");
            }

            for (int j = 0; j < (2 * i - 1); j++) {
                bufferedWriter.write("*");
            }

            bufferedWriter.newLine();

        }

        bufferedWriter.flush();

    }
}