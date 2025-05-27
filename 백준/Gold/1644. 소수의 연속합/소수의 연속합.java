import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        boolean[] isNotPrime = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);

                for (int j = i * 2; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int start = 0, end = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N) {
                    count++;
                }

                sum -= primes.get(start++);
            } else {
                if (end == primes.size()) {
                    break;
                }

                sum += primes.get(end++);
            }
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }
}