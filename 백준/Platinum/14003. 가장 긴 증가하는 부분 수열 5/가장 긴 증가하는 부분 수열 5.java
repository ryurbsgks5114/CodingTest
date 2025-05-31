import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int[] lisIndex = new int[N];
        int[] parent = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int length = 1;
        dp[0] = A[0];
        lisIndex[0] = 0;
        parent[0] = -1;

        for (int i = 1; i < N; i++) {
            if (A[i] > dp[length - 1]) {
                parent[i] = lisIndex[length - 1];
                dp[length] = A[i];
                lisIndex[length] = i;
                length++;
            } else {

                int idx = lowerBound(dp, 0, length, A[i]);

                dp[idx] = A[i];
                lisIndex[idx] = i;
                parent[i] = (idx == 0) ? -1 : lisIndex[idx - 1];
            }
        }

        bufferedWriter.write(length + "\n");

        Stack<Integer> stack = new Stack<>();
        int current = lisIndex[length - 1];

        while (current != -1) {
            stack.push(A[current]);
            current = parent[current];
        }

        while (!stack.isEmpty()) {
            bufferedWriter.write(stack.pop() + " ");
        }

        bufferedWriter.flush();

    }

    private static int lowerBound(int[] arr, int start, int end, int key) {
        while (start < end) {

            int mid = (start + end) / 2;

            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}