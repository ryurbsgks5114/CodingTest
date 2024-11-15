import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine().toUpperCase();
        int[] array = new int[26];

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            array[ch - 'A']++;

        }

        int max = 0;
        char ch = '?';
        boolean isCheck = false;

        for (int i = 0; i < 26; i++) {
            if (array[i] > max) {

                max = array[i];
                ch = (char) (i + 'A');
                isCheck = false;

            } else if (array[i] == max) {
                isCheck = true;
            }
        }

        if (isCheck) {
            bufferedWriter.write("?");
        } else {
            bufferedWriter.write(ch);
        }

        bufferedWriter.flush();

    }
}