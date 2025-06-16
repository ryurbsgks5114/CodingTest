import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int a, b, weight;

        Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int V = Integer.parseInt(stringTokenizer.nextToken());
        int E = Integer.parseInt(stringTokenizer.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            edges.add(new Edge(a, b, weight));
        }

        Collections.sort(edges);

        parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int count = 0;

        for (Edge el: edges) {

            int a = el.a;
            int b = el.b;

            if (find(a) == find(b)) {
                continue;
            }

            union(a, b);
            sum += el.weight;
            count++;

            if (count == V - 1) {
                break;
            }
        }

        bufferedWriter.write(sum + "");

        bufferedWriter.flush();

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

    static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        parent[rootB] = rootA;
    }
}