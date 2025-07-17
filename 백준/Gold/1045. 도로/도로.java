import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static class Edge implements Comparable<Edge> {

        int u;
        int v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            if (u == o.u) {
                return v - o.v;
            }

            return u - o.u;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        char[][] adj = new char[N][N];
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < N; j++) {
                adj[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (adj[i][j] == 'Y') {
                    edges.add(new Edge(i, j));
                }
            }
        }

        Collections.sort(edges);

        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        List<Edge> result = new ArrayList<>();

        for (Edge el: edges) {
            if (union(el.u, el.v)) {
                result.add(el);

                if (result.size() == N - 1) {
                    break;
                }
            }
        }

        if (result.size() != N - 1) {
            bufferedWriter.write("-1\n");
            bufferedWriter.flush();

            return;
        }

        for (Edge el: edges) {
            if (result.size() == M) {
                break;
            }

            if (!result.contains(el)) {
                result.add(el);
            }
        }

        if (result.size() != M) {
            bufferedWriter.write("-1\n");
            bufferedWriter.flush();

            return;
        }

        int[] count = new int[N];

        for (Edge el: result) {
            count[el.u]++;
            count[el.v]++;
        }

        for (int i = 0; i < N; i++) {
            bufferedWriter.write(count[i] + (i == N - 1 ? "\n" : " "));
        }

        bufferedWriter.flush();

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        parent[pb] = pa;

        return true;
    }
}