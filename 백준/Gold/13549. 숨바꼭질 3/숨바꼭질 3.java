import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100_001;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] time = new int[MAX];
        Arrays.fill(time, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(N);

        time[N] = 0;

        while (!deque.isEmpty()) {

            int current = deque.poll();

            if (current == K) {
                break;
            }

            if (2 * current < MAX && time[2 * current] == -1) {
                time[2 * current] = time[current];
                deque.offerFirst(2 * current);
            }

            if (current - 1 >= 0 && time[current - 1] == -1) {
                time[current - 1] = time[current] + 1;
                deque.offerLast(current - 1);
            }

            if (current + 1 < MAX && time[current + 1] == -1) {
                time[current + 1] = time[current] + 1;
                deque.offerLast(current + 1);
            }
        }

        bufferedWriter.write(time[K] + "\n");

        bufferedWriter.flush();

    }
}