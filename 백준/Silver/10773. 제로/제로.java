import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(bufferedReader.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {

            int input = Integer.parseInt(bufferedReader.readLine());

            if (input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }

        long sum = 0;

        for (int el: stack) {
            sum = sum + el;
        }

        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.newLine();

        bufferedWriter.flush();

    }
}