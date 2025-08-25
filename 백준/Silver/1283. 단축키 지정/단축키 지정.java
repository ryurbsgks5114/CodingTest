import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        Set<Character> used = new HashSet<>();

        for (int i = 0; i < N; i++) {

            String line = bufferedReader.readLine();
            String[] words = line.split(" ");
            boolean assigned = false;
            StringBuilder stringBuilder = new StringBuilder();

            int posWord = -1;
            int posChar = -1;

            for (int j = 0; j < words.length && !assigned; j++) {
                char c = Character.toLowerCase(words[j].charAt(0));

                if (!used.contains(c)) {
                    posWord = j;
                    posChar = 0;
                    assigned = true;
                }
            }

            if (!assigned) {
                outer:

                for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char c = Character.toLowerCase(words[j].charAt(k));

                        if (!used.contains(c)) {
                            posWord = j;
                            posChar = k;
                            assigned = true;

                            break outer;
                        }
                    }
                }
            }

            for (int j = 0; j < words.length; j++) {
                if (j > 0) {
                    stringBuilder.append(" ");
                }

                String word = words[j];

                if (j == posWord) {
                    stringBuilder.append(word, 0, posChar);
                    stringBuilder.append("[").append(word.charAt(posChar)).append("]");
                    stringBuilder.append(word.substring(posChar + 1));
                } else {
                    stringBuilder.append(word);
                }
            }

            if (assigned) {
                used.add(Character.toLowerCase(words[posWord].charAt(posChar)));
            }

            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}