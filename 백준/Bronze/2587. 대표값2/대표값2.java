import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
            sum = sum + numbers[i];
        }

        int average = sum / 5;

        Arrays.sort(numbers);

        int middle = numbers[2];

        bufferedWriter.write(String.valueOf(average));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(middle));

        bufferedWriter.flush();

    }
}