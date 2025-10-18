import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(bufferedReader.readLine());
        long digit = 10;

        while (N >= digit) {
            long remainder = N % digit;

            if (remainder >= digit / 2) {
                N += digit;
            }

            N -= remainder;
            digit *= 10;
        }

        bufferedWriter.write(String.valueOf(N));

        bufferedWriter.flush();

    }
}