import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        Main main = new Main();

        for (int i = 0; i < N; i++) {

            String word = bufferedReader.readLine();

            if (main.isGroupWord(word)) {
                count++;
            }

        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }

    public boolean isGroupWord(String word) {

        boolean[] array = new boolean[26];
        char ch = ' ';

        for (int i = 0; i < word.length(); i++) {

            char currentChar = word.charAt(i);

            if (currentChar != ch && array[currentChar - 'a']) {
                return false;
            }

            array[currentChar - 'a'] = true;
            ch = currentChar;

        }

        return true;
    }
}