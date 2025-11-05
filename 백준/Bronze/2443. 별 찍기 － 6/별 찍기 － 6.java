import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i - 1; j++) {
                bufferedWriter.write(' ');
            }

            for (int j = 0; j < 2 * (N - i) + 1; j++) {
                bufferedWriter.write('*');
            }
            
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}