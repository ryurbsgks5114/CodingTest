import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();
        int sum = 0;

        for (char el: word.toCharArray()) {
            if (Character.isLowerCase(el)) {
                sum += el - 'a' + 1;
            } else {
                sum += el - 'A' + 27;
            }
        }

        if (isPrime(sum)) {
            bufferedWriter.write("It is a prime word.\n");
        } else {
            bufferedWriter.write("It is not a prime word.\n");
        }

        bufferedWriter.flush();

    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return true;
        }

        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}