import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();

        Set<String> inputSet = new HashSet<>();

        int length = input.length();

        for (int i = 0; i < length; i++) {
            StringBuilder substring = new StringBuilder();

            for (int j = i; j < length; j++) {
                substring.append(input.charAt(j));
                inputSet.add(substring.toString());
            }
        }

        bufferedWriter.write(String.valueOf(inputSet.size()));

        bufferedWriter.flush();

    }
}