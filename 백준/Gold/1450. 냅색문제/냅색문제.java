import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long C;
    static long[] items;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        C = Long.parseLong(stringTokenizer.nextToken());

        items = new long[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            items[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        int mid = N / 2;

        long[] left = Arrays.copyOfRange(items, 0, mid);
        long[] right = Arrays.copyOfRange(items, mid, N);

        List<Long> leftSums = new ArrayList<>();
        List<Long> rightSums = new ArrayList<>();

        getSubsetSums(left, 0, 0, leftSums);
        getSubsetSums(right, 0, 0, rightSums);

        Collections.sort(rightSums);

        long count = 0;

        for (long el: leftSums) {

            long remain = C - el;
            int validRight = upperBound(rightSums, remain);

            count += validRight;
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }

    static void getSubsetSums(long[] arr, int idx, long sum, List<Long> result) {
        if (sum > C) {
            return;
        }

        if (idx == arr.length) {
            result.add(sum);

            return;
        }

        getSubsetSums(arr, idx + 1, sum, result);
        getSubsetSums(arr, idx + 1, sum + arr[idx], result);
    }

    static int upperBound(List<Long> list, long target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = (left + right) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}