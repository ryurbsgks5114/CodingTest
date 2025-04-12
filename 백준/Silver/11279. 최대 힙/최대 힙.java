import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {

            int x = Integer.parseInt(bufferedReader.readLine());

            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    bufferedWriter.write("0\n");
                } else {
                    bufferedWriter.write(maxHeap.poll() + "\n");
                }
            } else {
                maxHeap.offer(x);
            }
        }

        bufferedWriter.flush();

    }
}