import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int n = Integer.parseInt(stringTokenizer.nextToken());

            if (n == 0) {
                break;
            }

            long[] heights = new long[n];

            for (int i = 0; i < n; i++) {
                heights[i] = Long.parseLong(stringTokenizer.nextToken());
            }

            stringBuilder.append(getMaxArea(heights)).append("\n");
        }

        bufferedWriter.write(String.valueOf(stringBuilder));

        bufferedWriter.flush();

    }

    public static long getMaxArea(long[] heights) {

        Stack<Integer> stack = new Stack<>();

        long maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                long height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - 1 - stack.peek());

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {

            long height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : (n - 1 - (stack.isEmpty() ? -1 : stack.peek()));

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}