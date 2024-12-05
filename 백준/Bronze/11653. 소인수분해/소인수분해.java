import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                bufferedWriter.write(i + "\n");
                N = N / i;
            }
        }

        if (N > 1) {
            bufferedWriter.write(N + "\n");
        }

        bufferedWriter.flush();

    }
}