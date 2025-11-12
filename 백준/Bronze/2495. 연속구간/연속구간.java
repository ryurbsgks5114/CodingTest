import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 0; t < 3; t++) {
            String s = bufferedReader.readLine();
            int maxLen = 1;
            int currentLen = 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    currentLen++;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                    }
                } else {
                    currentLen = 1;
                }
            }

            bufferedWriter.write(maxLen + "\n");
        }

        bufferedWriter.flush();

    }
}