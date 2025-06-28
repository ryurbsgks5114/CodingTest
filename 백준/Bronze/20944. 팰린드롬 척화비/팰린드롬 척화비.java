import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder(N);

        for (int i = 0; i < N; i++) {
            stringBuilder.append('a');
        }

        bufferedWriter.write(stringBuilder + "\n");

        bufferedWriter.flush();

    }
}