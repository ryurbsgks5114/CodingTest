import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        long[] heights = new long[n];

        for (int i = 0; i < n; i++) {
            heights[i] = Long.parseLong(bufferedReader.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                long height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {

            long height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : (n - stack.peek() - 1);

            maxArea = Math.max(maxArea, height * width);
        }

        bufferedWriter.write(maxArea + "\n");

        bufferedWriter.flush();

    }
}