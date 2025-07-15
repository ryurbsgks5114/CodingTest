import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair> {

        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.value == other.value) {
                return this.index - other.index;
            }

            return this.value - other.value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] A = new int[N];
        Pair[] pairs = new Pair[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            pairs[i] = new Pair(A[i], i);
        }

        Arrays.sort(pairs);

        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[pairs[i].index] = i;
        }

        for (int i = 0; i < N; i++) {
            bufferedWriter.write(P[i] + " ");
        }

        bufferedWriter.flush();

    }
}