import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {

            String[] input = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int result = combination(M, N);

            bufferedWriter.write(result + "\n");

        }

        bufferedWriter.flush();

    }

    public static int combination(int m, int n) {
        if (n == 0 || m == n) {
            return 1;
        }

        int result = 1;

        for (int i = 0; i < n; i++) {
            result = result * (m - i);
            result = result / (i + 1);
        }

        return result;
    }
}