import java.io.*;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] sequence;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1];
        sequence = new int[M];

        backtracking(0);

        bufferedWriter.flush();

    }

    public static void backtracking(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bufferedWriter.write(sequence[i] + " ");
            }

            bufferedWriter.write("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}