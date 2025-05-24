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

        int x = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }
}