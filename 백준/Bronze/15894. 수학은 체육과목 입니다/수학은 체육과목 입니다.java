import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(bufferedReader.readLine());

        long perimeter = 4 * n;

        bufferedWriter.write(String.valueOf(perimeter));

        bufferedWriter.flush();

    }
}