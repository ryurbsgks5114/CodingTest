import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {
            for (int s = 0; s < N - i; s++) {
                bufferedWriter.write(" ");
            }

            for (int s = 0; s < i; s++) {
                bufferedWriter.write("*");
            }

            bufferedWriter.write("\n");
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int s = 0; s < N - i; s++) {
                bufferedWriter.write(" ");
            }

            for (int s = 0; s < i; s++) {
                bufferedWriter.write("*");
            }

            bufferedWriter.write("\n");
        }

        bufferedWriter.flush();

    }
}