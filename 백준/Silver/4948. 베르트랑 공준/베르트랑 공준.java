import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 246912;

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

        String input;

        while (!(input = bufferedReader.readLine()).equals("0")) {

            int n = Integer.parseInt(input);
            int count = 0;

            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isNotPrime[i]) {
                    count++;
                }
            }

            bufferedWriter.write(String.valueOf(count));
            bufferedWriter.newLine();

        }

        bufferedWriter.flush();

    }
}