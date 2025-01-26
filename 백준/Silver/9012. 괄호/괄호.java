import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {

            String input = bufferedReader.readLine();

            if (isValidParenthesisString(input)) {
                bufferedWriter.write("YES");
            } else {
                bufferedWriter.write("NO");
            }

            bufferedWriter.newLine();

        }

        bufferedWriter.flush();

    }

    private static boolean isValidParenthesisString(String s) {

        int balance = 0;

        for (char el: s.toCharArray()) {
            if (el == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}