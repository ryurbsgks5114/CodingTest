import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(bufferedReader.readLine());
        long time = 0;
        long k = 1;

        while (N > 0) {
            if (N < k) {
                k = 1;
            }

            N -= k;
            k++;
            time++;
        }

        bufferedWriter.write(time + "\n");

        bufferedWriter.flush();

    }
}