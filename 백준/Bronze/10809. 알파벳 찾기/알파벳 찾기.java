import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();
        int[] array = new int[26];

        for (int i = 0; i < 26; i++) {
            array[i] = -1;
        }

        for (int i = 0; i < S.length(); i++) {

            char ch = S.charAt(i);
            int index = ch - 'a';

            if (array[index] == -1) {
                array[index] = i;
            }

        }

        for (int i = 0; i < 26; i++) {
            bufferedWriter.write(array[i] + " ");
        }

        bufferedWriter.flush();

    }
}