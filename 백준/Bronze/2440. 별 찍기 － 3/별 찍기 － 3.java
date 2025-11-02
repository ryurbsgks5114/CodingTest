import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = N; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                bufferedWriter.write("*");
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}