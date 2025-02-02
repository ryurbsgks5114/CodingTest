import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] input = bufferedReader.readLine().split(" ");

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deque.offer(new int[]{i + 1, Integer.parseInt(input[i])});
        }

        StringBuilder result = new StringBuilder();

        while (!deque.isEmpty()) {

            int[] current = deque.pollFirst();

            result.append(current[0]).append(" ");

            if (deque.isEmpty()) {
                break;
            }

            int move = current[1];

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        bufferedWriter.write(result.toString().trim());

        bufferedWriter.flush();

    }
}