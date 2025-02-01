import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {

            String[] command = bufferedReader.readLine().split(" ");

            switch (command[0]) {
                case "1":
                    deque.addFirst(Integer.parseInt(command[1]));

                    break;
                case "2":
                    deque.addLast(Integer.parseInt(command[1]));

                    break;
                case "3":
                    bufferedWriter.write(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");

                    break;
                case "4":
                    bufferedWriter.write(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");

                    break;
                case "5":
                    bufferedWriter.write(deque.size() + "\n");

                    break;
                case "6":
                    bufferedWriter.write(deque.isEmpty() ? "1\n" : "0\n");

                    break;
                case "7":
                    bufferedWriter.write(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");

                    break;
                case "8":
                    bufferedWriter.write(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");

                    break;
            }
        }

        bufferedWriter.flush();

    }
}