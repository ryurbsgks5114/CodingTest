import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;

        for (int i = 0; i < 8; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0 && line.charAt(j) == 'F') {
                    count++;
                }
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }
}