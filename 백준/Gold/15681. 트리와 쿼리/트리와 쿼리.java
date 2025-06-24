import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] subtreeSize;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int Q = Integer.parseInt(stringTokenizer.nextToken());

        tree = new ArrayList[N + 1];
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            tree[U].add(V);
            tree[V].add(U);
        }

        dfs(R);

        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(bufferedReader.readLine());

            bufferedWriter.write(subtreeSize[u] + "\n");
        }

        bufferedWriter.flush();

    }

    public static int dfs(int node) {

        int size = 1;

        visited[node] = true;

        for (int el: tree[node]) {
            if (!visited[el]) {
                size += dfs(el);
            }
        }

        return subtreeSize[node] = size;
    }
}