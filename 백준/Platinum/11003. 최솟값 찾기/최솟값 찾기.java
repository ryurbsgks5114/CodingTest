import java.io.*;
import java.util.*;

public class Main {

    static class Pair {

        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        Deque<Pair> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            int now = Integer.parseInt(stringTokenizer.nextToken());

            while (!deque.isEmpty() && deque.getLast().value >= now) {
                deque.removeLast();
            }

            deque.addLast(new Pair(now, i));

            if (deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }

            bufferedWriter.write(deque.getFirst().value + " ");
        }

        bufferedWriter.flush();

    }
}