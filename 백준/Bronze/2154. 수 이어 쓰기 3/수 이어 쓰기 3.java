import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String target = String.valueOf(N);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            stringBuilder.append(i);
        }

        int index = stringBuilder.indexOf(target) + 1;

        bufferedWriter.write(index + "\n");

        bufferedWriter.flush();

    }
}