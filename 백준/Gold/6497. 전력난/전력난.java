import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());

            if (m == 0 && n == 0) {
                break;
            }

            parent = new int[m];

            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            List<Edge> edges = new ArrayList<>();

            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                int z = Integer.parseInt(stringTokenizer.nextToken());

                edges.add(new Edge(x, y, z));
                totalCost += z;
            }

            Collections.sort(edges);

            int mstCost = 0;

            for (Edge el: edges) {
                if (union(el.from, el.to)) {
                    mstCost += el.cost;
                }
            }

            stringBuilder.append(totalCost - mstCost).append("\n");
        }

        bufferedWriter.write(stringBuilder + "\n");

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