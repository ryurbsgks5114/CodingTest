import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");

        Main main = new Main();

        Integer A = main.reverseNumber(input[0]);
        Integer B = main.reverseNumber(input[1]);

        bufferedWriter.write(String.valueOf(Math.max(A, B)));

        bufferedWriter.flush();

    }

    private Integer reverseNumber(String number) {
        return Integer.parseInt(new StringBuilder(number).reverse().toString());
    }
}