import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] words = new char[5][15];
        int[] lengths = new int[5];

        for (int i = 0; i < 5; i++) {

            String input = bufferedReader.readLine();
            lengths[i] = input.length();

            for (int j = 0; j < lengths[i]; j++) {
                words[i][j] = input.charAt(j);
            }

        }

        String answer = "";

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < lengths[j]) {
                    answer = answer + words[j][i];
                }
            }
        }

        bufferedWriter.write(answer);

        bufferedWriter.flush();

    }
}