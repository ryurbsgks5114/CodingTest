import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = bufferedReader.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        int maxCount = 0;
        String answer = "";

        for (String el: map.keySet()) {
            int count = map.get(el);

            if (count > maxCount || (count == maxCount && el.compareTo(answer) < 0)) {
                maxCount = count;
                answer = el;
            }
        }

        bufferedWriter.write(answer + "\n");

        bufferedWriter.flush();

    }
}