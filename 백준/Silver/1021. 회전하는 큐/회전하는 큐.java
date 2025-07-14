import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> targets = new ArrayList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            targets.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int totalOps = 0;

        for (int el: targets) {

            int index = deque.indexOf(el);
            int size = deque.size();

            if (index <= size / 2) {
                for (int i = 0; i < index; i++) {
                    deque.addLast(deque.pollFirst());
                    totalOps++;
                }
            } else {
                for (int i = 0; i < size - index; i++) {
                    deque.addFirst(deque.pollLast());
                    totalOps++;
                }
            }

            deque.pollFirst();
        }

        bufferedWriter.write(totalOps + "\n");

        bufferedWriter.flush();

    }
}