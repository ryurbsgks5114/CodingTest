import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());

            if (n == 0) {
                break;
            }

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = bufferedReader.readLine();
            }

            Arrays.sort(words, (a, b) -> a.compareToIgnoreCase(b));

            bufferedWriter.write(words[0] + "\n");
        }

        bufferedWriter.flush();

    }
}