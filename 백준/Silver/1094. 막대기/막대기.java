import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        while (X > 0) {
            if (X % 2 == 1) {
                count++;
            }

            X /= 2;
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }
}