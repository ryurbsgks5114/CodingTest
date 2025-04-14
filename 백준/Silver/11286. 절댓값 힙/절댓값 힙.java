import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>( (a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA == absB) {
                return Integer.compare(a, b);
            }

            return Integer.compare(absA, absB);
        });

        for (int i = 0; i < N; i++) {

            int x = Integer.parseInt(bufferedReader.readLine());

            if (x == 0) {
                if (priorityQueue.isEmpty()) {
                    bufferedWriter.write("0\n");
                } else {
                    bufferedWriter.write(priorityQueue.poll() + "\n");
                }
            } else {
                priorityQueue.offer(x);
            }
        }

        bufferedWriter.flush();

    }
}