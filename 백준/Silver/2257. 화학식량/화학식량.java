import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String formula = bufferedReader.readLine().trim();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);

            if (ch == 'H') {
                stack.push(1);
            } else if (ch == 'C') {
                stack.push(12);
            } else if (ch == 'O') {
                stack.push(16);
            } else if (ch == '(') {
                stack.push(-1);
            } else if (ch == ')') {
                int sum = 0;

                while (!stack.isEmpty() && stack.peek() != -1) {
                    sum += stack.pop();
                }

                stack.pop();
                stack.push(sum);
            } else if (Character.isDigit(ch)) {
                int num = ch - '0';
                int top = stack.pop();

                stack.push(top * num);
            }
        }

        int result = 0;
        
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}