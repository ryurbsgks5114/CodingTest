import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(bufferedReader.readLine());

        int number = 0;
        int count = 0;

        while (count < X) {
            number++;
            count = count + number;
        }

        int offset = count - X;
        int numerator, denominator;

        if (number % 2 == 0) {
            numerator = number - offset;
            denominator = 1 + offset;
        } else {
            numerator = 1 + offset;
            denominator = number - offset;
        }

        bufferedWriter.write(numerator + "/" + denominator);

        bufferedWriter.flush();

    }
}