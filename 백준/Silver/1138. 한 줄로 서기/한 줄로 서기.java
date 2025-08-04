import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] tallerLeft = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            tallerLeft[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        List<Integer> result = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {

            int height = i + 1;
            int count = tallerLeft[i];

            result.add(count, height);
        }

        for (int el: result) {
            bufferedWriter.write(el + " ");
        }

        bufferedWriter.flush();

    }
}