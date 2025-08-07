import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            String name = bufferedReader.readLine();
            char first = name.charAt(0);

            count[first - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (count[i] >= 5) {
                result.append((char) (i + 'a'));
            }
        }

        if (result.length() == 0) {
            bufferedWriter.write("PREDAJA");
        } else {
            bufferedWriter.write(result.toString());
        }

        bufferedWriter.flush();

    }
}