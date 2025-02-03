import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] array = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(stringTokenizer.nextToken());

            if (array[i] == 0) {
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        while (M-- > 0) {

            int moveValue = Integer.parseInt(stringTokenizer.nextToken());

            deque.addFirst(moveValue);

            bufferedWriter.write(deque.pollLast() + " ");

        }

        bufferedWriter.flush();

    }
}