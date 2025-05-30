import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int[] prev = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            dp[i] = 1;
            prev[i] = -1;
        }

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        bufferedWriter.write(maxLen + "\n");

        Stack<Integer> stack = new Stack<>();

        while (lastIndex != -1) {
            stack.push(A[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        while (!stack.isEmpty()) {
            bufferedWriter.write(stack.pop() + " ");
        }

        bufferedWriter.write("\n");

        bufferedWriter.flush();

    }
}