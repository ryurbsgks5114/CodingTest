import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            
            int x = Integer.parseInt(bufferedReader.readLine());

            if (x == 0) {
                if (minHeap.isEmpty()) {
                    bufferedWriter.write("0\n");
                } else {
                    bufferedWriter.write(minHeap.poll() + "\n");
                }
            } else {
                minHeap.offer(x);
            }
        }

        bufferedWriter.flush();

    }
}