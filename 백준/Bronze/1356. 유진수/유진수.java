import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine().trim();
        int len = s.length();

        boolean isOk = false;

        for (int i = 1; i < len && !isOk; i++) {
            long left = 1L, right = 1L;

            for (int j = 0; j < i; j++) {
                left *= (s.charAt(j) - '0');
            }

            for (int j = i; j < len; j++) {
                right *= (s.charAt(j) - '0');
            }

            if (left == right) {
                isOk = true;
            }
        }

        bufferedWriter.write(isOk ? "YES" : "NO");

        bufferedWriter.flush();

    }
}