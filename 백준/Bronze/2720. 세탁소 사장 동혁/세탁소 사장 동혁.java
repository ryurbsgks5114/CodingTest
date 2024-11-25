import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());
        int[] coins = { 25, 10, 5, 1 };

        for (int i = 0; i < T; i++) {

            int C = Integer.parseInt(bufferedReader.readLine());
            String result = "";

            for (int j = 0; j < coins.length; j++) {

                int count = C / coins[j];
                C = C % coins[j];
                result = result + count + " ";

            }

            bufferedWriter.write(result);
            bufferedWriter.newLine();

        }

        bufferedWriter.flush();

    }
}