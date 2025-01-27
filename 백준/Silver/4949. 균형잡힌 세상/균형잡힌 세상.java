import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            String input = bufferedReader.readLine();

            if (input.equals(".")) {
                break;
            }

            if (isBalance(input)) {
                bufferedWriter.write("yes");
            } else {
                bufferedWriter.write("no");
            }

            bufferedWriter.newLine();

        }

        bufferedWriter.flush();

    }

    private static boolean isBalance(String input) {

        Stack<Character> stack = new Stack<>();

        for (char el: input.toCharArray()) {
            if (el == '(' || el == '[') {
                stack.push(el);
            } else if (el == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (el == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}