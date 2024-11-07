import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {

            String str = bufferedReader.readLine();
            String answer = String.valueOf(str.charAt(0)) + str.charAt(str.length() - 1);
            bufferedWriter.write(answer + "\n");

        }

        bufferedWriter.flush();

    }
}