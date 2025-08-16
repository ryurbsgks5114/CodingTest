import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String num = bufferedReader.readLine();

            if (num.equals("0")) {
                break;
            }

            int width = 2;

            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);

                if (c == '1') {
                    width += 2;
                } else if (c == '0') {
                    width += 4;
                } else {
                    width += 3;
                }
            }

            width += (num.length() - 1);

            bufferedWriter.write(String.valueOf(width));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}