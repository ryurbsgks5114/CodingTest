import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        if (N == 1) {

            bufferedWriter.write(String.valueOf(N));

            bufferedWriter.flush();

            return;
        }

        long room = 1;
        long number = 1;

        while (number < N) {
            number = number + 6 * room;
            room++;
        }

        bufferedWriter.write(String.valueOf(room));

        bufferedWriter.flush();

    }
}