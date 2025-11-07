import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= 2 * N - 1; i++) {
            int spaceCount, starCount;

            if (i <= N) {
                spaceCount = i - 1;
                starCount = 2 * (N - i) + 1;
            } else {
                spaceCount = (2 * N - 1) - i;
                starCount = 2 * (i - N) + 1;
            }

            for (int j = 0; j < spaceCount; j++) {
                bufferedWriter.write(' ');
            }

            for (int j = 0; j < starCount; j++) {
                bufferedWriter.write('*');
            }
            
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}