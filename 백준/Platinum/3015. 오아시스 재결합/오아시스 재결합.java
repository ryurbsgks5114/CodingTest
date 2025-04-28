import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        Stack<int[]> stack = new Stack<>();
        long count = 0;

        for (int i = 0; i < n; i++) {

            int height = Integer.parseInt(bufferedReader.readLine());
            int cnt = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= height) {

                int[] top = stack.pop();
                
                count += top[1];

                if (top[0] == height) {
                    cnt += top[1];
                }
            }

            if (!stack.isEmpty()) {
                count++;
            }

            stack.push(new int[]{height, cnt});
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }
}