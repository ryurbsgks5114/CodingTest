import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] numbers = new String[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = bufferedReader.readLine();
        }

        int length = numbers[0].length();
        int answer = length;

        for (int i = 1; i <= length; i++) {

            Set<String> set = new HashSet<>();
            boolean duplicate = false;

            for (String el: numbers) {
                String sub = el.substring(length - i);

                if (!set.add(sub)) {
                    duplicate = true;

                    break;
                }
            }

            if (!duplicate) {
                answer = i;

                break;
            }
        }

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();

    }
}