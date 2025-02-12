import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(bufferedReader.readLine());

            numbers[i] = num;
            sum = sum + num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);

        }

        Arrays.sort(numbers);

        int mean = (int) Math.round((double) sum / N);

        int median = numbers[N / 2];

        List<Integer> list = new ArrayList<>();

        int maxFreq = Collections.max(map.values());

        for (Map.Entry<Integer, Integer> el : map.entrySet()) {
            if (el.getValue() == maxFreq) {
                list.add(el.getKey());
            }
        }

        Collections.sort(list);

        int mode = (list.size() > 1) ? list.get(1) : list.get(0);

        int range = max - min;

        bufferedWriter.write(mean + "\n");
        bufferedWriter.write(median + "\n");
        bufferedWriter.write(mode + "\n");
        bufferedWriter.write(range + "\n");

        bufferedWriter.flush();

    }
}