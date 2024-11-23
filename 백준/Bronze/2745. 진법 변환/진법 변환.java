import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        String N = input[0];
        int B = Integer.parseInt(input[1]);

        int value = 0;
        int power = 1;

        for (int i = N.length() - 1; i >= 0; i--) {

            char digit = N.charAt(i);

            if (Character.isDigit(digit)) {
                value = value + (digit - '0') * power;
            } else {
                value = value + (digit - 'A' + 10) * power;
            }

            power = power * B;

        }

        bufferedWriter.write(String.valueOf(value));

        bufferedWriter.flush();

    }
}