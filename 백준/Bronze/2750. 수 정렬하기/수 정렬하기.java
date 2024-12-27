import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        Collections.sort(numbers);

        for (int num : numbers) {
            bufferedWriter.write(String.valueOf(num));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}