import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = bufferedReader.readLine();
        }

        Arrays.sort(array, (s1, s2) -> Integer.compare(s2.length(), s1.length()));

        Set<String> set = new HashSet<>();

        for (String el: array) {
            boolean available = true;

            for (String element: set) {
                if (element.startsWith(el)) {
                    available = false;

                    break;
                }
            }

            if (available) {
                set.add(el);
            }
        }

        bufferedWriter.write(String.valueOf(set.size()));

        bufferedWriter.flush();

    }
}