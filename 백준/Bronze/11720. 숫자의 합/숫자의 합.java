import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String number = bufferedReader.readLine();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum = sum + number.charAt(i) - '0';
        }

        bufferedWriter.write(String.valueOf(sum));

        bufferedWriter.flush();

    }
}