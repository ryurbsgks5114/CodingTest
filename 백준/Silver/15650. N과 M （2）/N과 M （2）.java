import java.io.*;

public class Main {

    static int N, M;
    static int[] sequence;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        sequence = new int[M];

        backtracking(0, 1);

        bufferedWriter.flush();

    }

    public static void backtracking(int depth, int start) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bufferedWriter.write(sequence[i] + " ");
            }

            bufferedWriter.write("\n");

            return;
        }

        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            backtracking(depth + 1, i + 1);
        }
    }
}