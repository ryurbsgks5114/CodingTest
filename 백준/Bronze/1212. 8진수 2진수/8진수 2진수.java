import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();

        if (input.equals("0")) {
            bufferedWriter.write("0\n");
            bufferedWriter.flush();

            return;
        }

        int first = input.charAt(0) - '0';

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toBinaryString(first));

        for (int i = 1; i < input.length(); i++) {

            int num = input.charAt(i) - '0';
            String bin = Integer.toBinaryString(num);

            while (bin.length() < 3) {
                bin = "0" + bin;
            }

            stringBuilder.append(bin);
        }

        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.flush();

    }
}