import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {

            String input = bufferedReader.readLine();

            if (input.startsWith("1")) {

                int X = Integer.parseInt(input.split(" ")[1]);

                stack.push(X);

            } else if (input.equals("2")) {
                if (stack.isEmpty()) {
                    bufferedWriter.write("-1\n");
                } else {
                    bufferedWriter.write(stack.pop() + "\n");
                }
            } else if (input.equals("3")) {
                bufferedWriter.write(stack.size() + "\n");
            } else if (input.equals("4")) {
                bufferedWriter.write((stack.isEmpty() ? "1" : "0") + "\n");
            } else if (input.equals("5")) {
                if (stack.isEmpty()) {
                    bufferedWriter.write("-1\n");
                } else {
                    bufferedWriter.write(stack.peek() + "\n");
                }
            }
        }

        bufferedWriter.flush();

    }
}