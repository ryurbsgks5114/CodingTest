import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        int N = 0;

        while (true) {
            N++;
            stringBuilder.append(N);

            if (isSubsequence(S, stringBuilder)) {
                bufferedWriter.write(String.valueOf(N));
                bufferedWriter.flush();

                return;
            }
        }
    }

    private static boolean isSubsequence(String s, StringBuilder t) {
        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s.length();
    }
}