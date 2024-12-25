import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int count = 0;
        int number = 666;

        while (count < N) {
            if (String.valueOf(number).contains("666")) {
                count++;
            }

            if (count < N) {
                number++;
            }
        }

        bufferedWriter.write(String.valueOf(number));
        bufferedWriter.flush();

    }
}