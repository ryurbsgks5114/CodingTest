import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {

            int M = Integer.parseInt(bufferedReader.readLine());
            int total = (M + 9) / 10;
            List<Integer> nums = new ArrayList<>();

            while (nums.size() < M) {

                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                while (stringTokenizer.hasMoreTokens()) {
                    nums.add(Integer.parseInt(stringTokenizer.nextToken()));
                }
            }

            List<Integer> result = new ArrayList<>();
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            for (int i = 0; i < M; i++) {

                int num = nums.get(i);

                if (left.isEmpty() || num <= left.peek()) {
                    left.offer(num);
                } else {
                    right.offer(num);
                }

                if (left.size() > right.size() + 1) {
                    right.offer(left.poll());
                } else if (left.size() < right.size()) {
                    left.offer(right.poll());
                }

                if (i % 2 == 0) {
                    result.add(left.peek());
                }
            }

            bufferedWriter.write(result.size() + "\n");

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(result.get(i) + " ");

                if ((i + 1) % 10 == 0) {
                    bufferedWriter.write("\n");
                }
            }

            if (result.size() % 10 != 0) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.flush();

    }
}