import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= 2 * N - 1; i++) {
            int stars = (i <= N) ? i : 2 * N - i;
            int spaces = 2 * (N - stars);

            for (int j = 0; j < stars; j++) {
                bufferedWriter.write('*');
            }

            for (int j = 0; j < spaces; j++) {
                bufferedWriter.write(' ');
            }

            for (int j = 0; j < stars; j++) {
                bufferedWriter.write('*');
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}