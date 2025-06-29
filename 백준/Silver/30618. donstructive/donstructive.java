import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Pos[] positions = new Pos[N];

        for (int i = 0; i < N; i++) {
            long weight = (long)(i + 1) * (N - i);

            positions[i] = new Pos(i, weight);
        }

        Arrays.sort(positions);

        int[] result = new int[N];
        int num = N;

        for (Pos pos: positions) {
            result[pos.index] = num--;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int el: result) {
            stringBuilder.append(el).append(" ");
        }

        bufferedWriter.write(stringBuilder.toString().trim() + "\n");

        bufferedWriter.flush();

    }

    static class Pos implements Comparable<Pos> {

        int index;
        long weight;

        public Pos(int index, long weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pos o) {
            return Long.compare(o.weight, this.weight);
        }
    }
}