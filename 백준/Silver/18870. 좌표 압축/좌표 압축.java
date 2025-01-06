import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] input = bufferedReader.readLine().split(" ");
        int[] original = new int[N];
        int[] sorted = new int[N];

        for (int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(input[i]);
            sorted[i] = original[i];
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> compressedMap = new HashMap<>();

        int rank = 0;

        for (int el: sorted) {
            if (!compressedMap.containsKey(el)) {
                compressedMap.put(el, rank++);
            }
        }

        for (int el: original) {
            bufferedWriter.write(compressedMap.get(el) + " ");
        }

        bufferedWriter.flush();

    }
}