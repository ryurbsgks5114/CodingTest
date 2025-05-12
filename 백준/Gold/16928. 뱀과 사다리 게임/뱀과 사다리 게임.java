import java.io.*;
import java.util.*;

public class Main {

    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());

            board[from] = to;
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());

            board[from] = to;
        }

        bufferedWriter.write(bfs() + "\n");

        bufferedWriter.flush();

    }

    public static int bfs() {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{ 1, 0 });
        visited[1] = true;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int position = curr[0];
            int count = curr[1];

            if (position == 100) {
                return count;
            }

            for (int i = 1; i <= 6; i++) {

                int next = position + i;

                if (next > 100) {
                    continue;
                }

                if (board[next] != 0) {
                    next = board[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{ next, count + 1 });
                }
            }
        }

        return -1;
    }
}