import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int minSum = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        if (ans1 < ans2) {
            bufferedWriter.write(ans1 + " " + ans2 + "\n");
        } else {
            bufferedWriter.write(ans2 + " " + ans1 + "\n");
        }

        bufferedWriter.flush();

    }
}