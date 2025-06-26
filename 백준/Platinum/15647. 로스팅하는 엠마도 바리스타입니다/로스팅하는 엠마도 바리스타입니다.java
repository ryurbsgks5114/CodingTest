import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Node>[] tree;
    static long[] distSum;
    static int[] subtreeSize;
    static boolean[] visited;

    static class Node {

        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());

            tree[u].add(new Node(v, d));
            tree[v].add(new Node(u, d));
        }

        distSum = new long[N + 1];
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];

        dfs1(1, 0);

        visited = new boolean[N + 1];

        dfs2(1, 0);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            stringBuilder.append(distSum[i]).append("\n");
        }

        bufferedWriter.write(stringBuilder + "\n");

        bufferedWriter.flush();

    }

    static void dfs1(int current, int depth) {
        visited[current] = true;
        subtreeSize[current] = 1;

        for (Node el: tree[current]) {
            if (!visited[el.to]) {
                dfs1(el.to, depth + 1);

                subtreeSize[current] += subtreeSize[el.to];
                distSum[1] += (long) el.weight * subtreeSize[el.to];
            }
        }
    }

    static void dfs2(int current, int parent) {
        visited[current] = true;

        for (Node el: tree[current]) {
            if (!visited[el.to]) {
                distSum[el.to] = distSum[current] + (long)(N - 2 * subtreeSize[el.to]) * el.weight;

                dfs2(el.to, current);
            }
        }
    }
}