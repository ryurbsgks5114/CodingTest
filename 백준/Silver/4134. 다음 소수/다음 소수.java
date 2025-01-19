import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(bufferedReader.readLine());

        while (input-- > 0) {

            long n = Long.parseLong(bufferedReader.readLine());
            long result = findPrime(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

        }

        bufferedWriter.flush();

    }

    public static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static long findPrime(long n) {
        if (n <= 2) {
            return 2;
        }

        if (n % 2 == 0) {
            n++;
        }

        while (!isPrime(n)) {
            n = n + 2;
        }

        return n;
    }
}