import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = bufferedReader.readLine();
        int[] count = new int[26];

        for (char c: name.toCharArray()) {
            count[c - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                oddIndex = i;
            }
        }

        if ((name.length() % 2 == 0 && oddCount > 0) || (name.length() % 2 == 1 && oddCount != 1)) {
            bufferedWriter.write("I'm Sorry Hansoo\n");
            bufferedWriter.flush();

            return;
        }

        StringBuilder half = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                half.append((char) (i + 'A'));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half);

        if (oddIndex != -1) {
            result.append((char) (oddIndex + 'A'));
        }

        result.append(half.reverse());

        bufferedWriter.write(result.toString());

        bufferedWriter.flush();

    }
}