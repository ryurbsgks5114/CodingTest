import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Set<String> set = new HashSet<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();

            if (input.equals("ENTER")) {
                set.clear();
            } else if (!set.contains(input)) {
                set.add(input);
                count++;
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }
}