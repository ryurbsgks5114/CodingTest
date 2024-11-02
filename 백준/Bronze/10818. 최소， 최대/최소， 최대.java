import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.valueOf(bufferedReader.readLine());
        String[] array = bufferedReader.readLine().split(" ");

        Main main = new Main();
        bufferedWriter.write(main.findMinAndMax(array, N));

        bufferedWriter.flush();

    }

    private String findMinAndMax (String[] array, Integer N) {

        Integer[] IntegerArray = new Integer[N];

        for (int i = 0; i < N; i++) {
            IntegerArray[i] = Integer.valueOf(array[i]);
        }

        Integer min = Arrays.stream(IntegerArray).min(Integer::compareTo).orElse(0);
        Integer max = Arrays.stream(IntegerArray).max(Integer::compareTo).orElse(0);

        return min + " " + max;
    }
}