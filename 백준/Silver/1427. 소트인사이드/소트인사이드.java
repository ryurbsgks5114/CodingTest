import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();

        char[] array = input.toCharArray();

        Arrays.sort(array);

        StringBuilder sortedNumber = new StringBuilder(new String(array));
        sortedNumber.reverse();

        bufferedWriter.write(sortedNumber.toString());

        bufferedWriter.flush();

    }
}