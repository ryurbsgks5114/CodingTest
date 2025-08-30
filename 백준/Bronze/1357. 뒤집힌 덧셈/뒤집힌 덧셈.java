import java.io.*;

public class Main {

    static int rev(int n) {
        int res = 0;

        while (n > 0) {
            res = res * 10 + (n % 10);
            n /= 10;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int Y = Integer.parseInt(input[1]);

        int result = rev(rev(X) + rev(Y));

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();

    }
}