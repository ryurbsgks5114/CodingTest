import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = bufferedReader.readLine();

            if (s.equals("0")) {
                break;
            }

            while (s.length() > 1) {
                int sum = 0;

                for (int i = 0; i < s.length(); i++) {
                    sum += s.charAt(i) - '0';
                }

                s = String.valueOf(sum);
            }

            bufferedWriter.write(s + "\n");
        }

        bufferedWriter.flush();

    }
}