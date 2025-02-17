import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K, count = 0;
    static int result = -1;
    static int[] A, tmp;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        A = new int[N];
        tmp = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        mergeSort(0, N - 1);

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();

    }

    public static void mergeSort(int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);

        }
    }

    public static void merge(int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = A[i++];
        }

        while (j <= right) {
            tmp[t++] = A[j++];
        }

        for (i = left, t = 0; i <= right; i++, t++) {
            A[i] = tmp[t];
            count++;

            if (count == K) {
                result = A[i];
            }
        }
    }
}