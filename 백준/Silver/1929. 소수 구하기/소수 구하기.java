import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j = j + i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                bufferedWriter.write(String.valueOf(i));
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.flush();

    }
}