import java.io.*;
import java.util.*;

public class Main {

    static List<Edge>[] tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    static class Edge {

        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());

            while (true) {

                int to = Integer.parseInt(stringTokenizer.nextToken());

                if (to == -1) {
                    break;
                }

                int weight = Integer.parseInt(stringTokenizer.nextToken());

                tree[from].add(new Edge(to, weight));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        bufferedWriter.write(maxDist + "\n");

        bufferedWriter.flush();

    }

    static void dfs(int current, int sum) {
        visited[current] = true;

        if (sum > maxDist) {
            maxDist = sum;
            farthestNode = current;
        }

        for (Edge el: tree[current]) {
            if (!visited[el.to]) {
                dfs(el.to, sum + el.weight);
            }
        }
    }
}