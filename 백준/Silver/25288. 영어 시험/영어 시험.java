import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String alphabetLine = bufferedReader.readLine();
        char[] chars = alphabetLine.toCharArray();

        Arrays.sort(chars);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (char c: chars) {
                stringBuilder.append(c);
            }
        }

        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.flush();

    }
}