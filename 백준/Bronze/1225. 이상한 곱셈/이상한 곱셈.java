import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        String A = input[0];
        String B = input[1];
        long sumA = 0;
        long sumB = 0;

        for (char c: A.toCharArray()) {
            sumA += c - '0';
        }

        for (char c: B.toCharArray()) {
            sumB += c - '0';
        }

        long result = sumA * sumB;

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();

    }
}