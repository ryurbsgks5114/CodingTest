import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static class Edge implements Comparable<Edge> {

        int a, b;
        double dist;

        Edge(int a, int b, double dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        double[][] stars = new double[n][2];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stars[i][0] = Double.parseDouble(stringTokenizer.nextToken());
            stars[i][1] = Double.parseDouble(stringTokenizer.nextToken());
        }

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            union(a, b);
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                double dx = stars[i][0] - stars[j][0];
                double dy = stars[i][1] - stars[j][1];
                double dist = Math.sqrt(dx * dx + dy * dy);

                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);

        double result = 0;

        for (Edge el: edges) {
            if (find(el.a) != find(el.b)) {
                union(el.a, el.b);
                result += el.dist;
            }
        }

        bufferedWriter.write(String.format("%.2f\n", result));

        bufferedWriter.flush();

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}