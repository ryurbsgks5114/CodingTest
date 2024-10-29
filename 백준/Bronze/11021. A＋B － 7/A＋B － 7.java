import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bufferedReader.readLine());

        Main main = new Main();

        for (int i = 0; i < T; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            Integer A = Integer.valueOf(input[0]);
            Integer B = Integer.valueOf(input[1]);

            bufferedWriter.write(main.addTwoNumbers(A, B, i) + "\n");

        }

        bufferedWriter.flush();

    }

    private String addTwoNumbers (Integer A, Integer B, int i) {
        return "Case #" + (i + 1) + ": " + (A + B);
    }
}