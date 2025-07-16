import java.io.*;
import java.util.*;

public class Main {

    static class Pair {

        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Pair[] pairs = new Pair[N];

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(stringTokenizer.nextToken());

            B[i] = val;
            pairs[i] = new Pair(val, i);
        }

        Arrays.sort(A);

        Arrays.sort(pairs, (p1, p2) -> p2.value - p1.value);

        int[] rearrangedA = new int[N];

        for (int i = 0; i < N; i++) {
            rearrangedA[pairs[i].index] = A[i];
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            result += rearrangedA[i] * B[i];
        }

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}