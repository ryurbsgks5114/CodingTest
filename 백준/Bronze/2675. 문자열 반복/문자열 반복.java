import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            String S = input[1];

            String result = "";

            for (int j = 0; j < S.length(); j++) {

                char ch = S.charAt(j);

                result = result + String.valueOf(ch).repeat(R);

            }

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}