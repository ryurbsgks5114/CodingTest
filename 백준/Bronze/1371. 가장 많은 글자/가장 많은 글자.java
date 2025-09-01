import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] freq = new int[26];
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            for (char c: line.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    freq[c - 'a']++;
                }
            }
        }

        int max = 0;

        for (int f: freq) {
            if (f > max) {
                max = f;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == max) {
                bufferedWriter.write((char) (i + 'a'));
            }
        }

        bufferedWriter.flush();

    }
}