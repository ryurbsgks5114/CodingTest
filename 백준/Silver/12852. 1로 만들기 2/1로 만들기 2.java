import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;

        for (int i = N; i >= 1; i--) {
            if (i % 3 == 0 && dp[i / 3] > dp[i] + 1) {
                dp[i / 3] = dp[i] + 1;
                prev[i / 3] = i;
            }

            if (i % 2 == 0 && dp[i / 2] > dp[i] + 1) {
                dp[i / 2] = dp[i] + 1;
                prev[i / 2] = i;
            }

            if (i - 1 >= 1 && dp[i - 1] > dp[i] + 1) {
                dp[i - 1] = dp[i] + 1;
                prev[i - 1] = i;
            }
        }

        bufferedWriter.write(dp[1] + "\n");

        Stack<Integer> stack = new Stack<>();

        int curr = 1;
        
        while (curr != 0) {
            stack.push(curr);
            curr = prev[curr];
        }

        while (!stack.isEmpty()) {
            bufferedWriter.write(stack.pop() + " ");
        }

        bufferedWriter.write("\n");

        bufferedWriter.flush();

    }
}