import java.io.*;
import java.util.*;

public class Main {

    static final int LIMIT = 1_000_000;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        sieve();

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            long S = Long.parseLong(bufferedReader.readLine());

            bufferedWriter.write(isValidKey(S) ? "YES\n" : "NO\n");
        }

        bufferedWriter.flush();

    }

    static void sieve() {

        boolean[] isComposite = new boolean[LIMIT + 1];

        for (int i = 2; i * i <= LIMIT; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        for (int i = 2; i <= LIMIT; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }
    }

    static boolean isValidKey(long S) {
        for (int el: primes) {
            if ((long) el * el > S) {
                break;
            }
            
            if (S % el == 0) {
                return false;
            }
        }

        return true;
    }
}