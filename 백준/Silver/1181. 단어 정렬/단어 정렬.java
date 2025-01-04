import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            wordSet.add(bufferedReader.readLine());
        }

        List<String> wordList = new ArrayList<>(wordSet);

        wordList.sort( (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }

            return Integer.compare(a.length(), b.length());
        });

        for (String word: wordList) {
            bufferedWriter.write(word);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}