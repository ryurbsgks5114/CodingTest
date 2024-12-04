import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bufferedReader.readLine());
        int N = Integer.parseInt(bufferedReader.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;

        Main main = new Main();

        for (int i = M; i <= N; i++) {
            if (main.isPrime(i)) {
                sum = sum + i;

                if (i < min) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            bufferedWriter.write("-1");
        } else {
            bufferedWriter.write(String.valueOf(sum));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(min));
        }

        bufferedWriter.flush();

    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}