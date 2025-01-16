import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        long lcm = LCM(A, B);

        bufferedWriter.write(String.valueOf(lcm));

        bufferedWriter.flush();

    }

    public static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }

    public static long LCM(long a, long b) {
        return a * b / GCD(a, b);
    }
}