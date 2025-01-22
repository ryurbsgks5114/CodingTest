import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());
        int max = 1000000;
        boolean[] isNotPrime = new boolean[max + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= max; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= max; j = j + i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(bufferedReader.readLine());
            int count = 0;

            for (int j = 2; j <= N / 2; j++) {
                if (!isNotPrime[j] && !isNotPrime[N - j]) {
                    count++;
                }
            }

            bufferedWriter.write(String.valueOf(count));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}