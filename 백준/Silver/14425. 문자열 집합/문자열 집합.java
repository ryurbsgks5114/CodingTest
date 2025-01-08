import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(bufferedReader.readLine());
        }

        int count = 0;

        for (int i = 0; i < M; i++) {

            String newInput = bufferedReader.readLine();

            if (set.contains(newInput)) {
                count++;
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }
}