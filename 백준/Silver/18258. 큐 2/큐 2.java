import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {

            String[] command = bufferedReader.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    queue.offer(Integer.parseInt(command[1]));

                    break;
                case "pop":
                    bufferedWriter.write(queue.isEmpty() ? "-1\n" : queue.poll() + "\n");

                    break;
                case "size":
                    bufferedWriter.write(queue.size() + "\n");

                    break;
                case "empty":
                    bufferedWriter.write(queue.isEmpty() ? "1\n" : "0\n");

                    break;
                case "front":
                    bufferedWriter.write(queue.isEmpty() ? "-1\n" : queue.peek() + "\n");

                    break;
                case "back":
                    bufferedWriter.write(queue.isEmpty() ? "-1\n" : queue.peekLast() + "\n");

                    break;
            }
        }

        bufferedWriter.flush();

    }
}