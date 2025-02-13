import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = bufferedReader.readLine();

            if (word.length() >= M) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(wordCount.keySet());

        words.sort( (w1, w2) -> {
            int freq1 = wordCount.get(w1);
            int freq2 = wordCount.get(w2);

            if (freq1 != freq2) {
                return Integer.compare(freq2, freq1);
            }

            if (w1.length() != w2.length()) {
                return Integer.compare(w2.length(), w1.length());
            }

            return w1.compareTo(w2);
        });

        for (String el: words) {
            bufferedWriter.write(el + "\n");
        }

        bufferedWriter.flush();

    }
}