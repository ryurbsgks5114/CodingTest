import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static class Edge implements Comparable<Edge> {

        int a, b;
        double weight;

        Edge(int a, int b, double weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static class Point {

        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            String[] arr = bufferedReader.readLine().split(" ");
            points[i] = new Point(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                double dist = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) +
                        Math.pow(points[i].y - points[j].y, 2));

                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double sum = 0;
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

            if (count == n - 1) {
                break;
            }
        }

        bufferedWriter.write(String.format("%.2f\n", sum));

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