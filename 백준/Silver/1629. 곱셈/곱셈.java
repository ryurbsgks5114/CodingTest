import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long A;
    static long B;
    static long C;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        A = Long.parseLong(stringTokenizer.nextToken());
        B = Long.parseLong(stringTokenizer.nextToken());
        C = Long.parseLong(stringTokenizer.nextToken());

        bufferedWriter.write(String.valueOf(power(A, B)));

        bufferedWriter.flush();

    }

    static long power(long base, long exp) {
        if (exp == 1) {
            return base % C;
        }

        long half = power(base, exp / 2);
        half = (half * half) % C;

        if (exp % 2 == 0) {
            return half;
        } else {
            return (half * (base % C)) % C;
        }
    }
}