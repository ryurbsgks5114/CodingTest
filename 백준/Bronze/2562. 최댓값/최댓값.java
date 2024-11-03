import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] array = new Integer[9];

        for (int i = 0; i < 9; i++) {
            array[i] = Integer.valueOf(bufferedReader.readLine());
        }

        Main main = new Main();
        Integer max = main.findMax(array);
        int index = main.findMaxIndex(array, max);

        bufferedWriter.write(max + "\n" + index);

        bufferedWriter.flush();

    }

    private Integer findMax (Integer[] array) {
        return Arrays.stream(array).max(Integer::compareTo).orElse(0);
    }

    private int findMaxIndex (Integer[] array, Integer max) {

        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(max)) {
                answer = i + 1;
            }
        }

        return answer;
    }
}