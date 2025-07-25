import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int F = Integer.parseInt(bufferedReader.readLine());
        int front = (N / 100) * 100;
        int result = 0;

        for (int i = 0; i < 100; i++) {
            if ((front + i) % F == 0) {
                result = i;

                break;
            }
        }

        bufferedWriter.write(String.format("%02d\n", result));

        bufferedWriter.flush();

    }
}