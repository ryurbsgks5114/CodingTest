import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] arr = new int[N];
        int[] lis = new int[N];
        int length = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

            int pos = Arrays.binarySearch(lis, 0, length, arr[i]);

            if (pos < 0) {
                pos = -(pos + 1);
            }

            lis[pos] = arr[i];

            if (pos == length) {
                length++;
            }
        }

        bufferedWriter.write(length + "\n");

        bufferedWriter.flush();

    }
}