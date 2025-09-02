import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String binary = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        int len = binary.length();
        int mod = len % 3;

        if (mod == 1) {
            binary = "00" + binary;
        } else if (mod == 2) {
            binary = "0" + binary;
        }

        for (int i = 0; i < binary.length(); i += 3) {
            int val = (binary.charAt(i) - '0') * 4
                    + (binary.charAt(i + 1) - '0') * 2
                    + (binary.charAt(i + 2) - '0');

            stringBuilder.append(val);
        }

        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }

        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.flush();

    }
}