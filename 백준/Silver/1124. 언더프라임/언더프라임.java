import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int max = 100000;
        boolean[] isPrime = new boolean[max + 1];

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] factorCount = new int[max + 1];

        for (int i = 2; i <= max; i++) {

            int num = i;
            int count = 0;
            int divisor = 2;

            while (num > 1) {
                if (num % divisor == 0) {
                    count++;
                    num /= divisor;
                } else {
                    divisor++;
                }
            }

            factorCount[i] = count;
        }

        int underprimeCount = 0;

        for (int i = A; i <= B; i++) {
            if (isPrime[factorCount[i]]) {
                underprimeCount++;
            }
        }

        bufferedWriter.write(String.valueOf(underprimeCount));

        bufferedWriter.flush();

    }
}