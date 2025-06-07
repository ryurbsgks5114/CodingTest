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

        int n = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parent = Integer.parseInt(stringTokenizer.nextToken());
            int child = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            tree[parent].add(new Edge(child, weight));
            tree[child].add(new Edge(parent, weight));
        }

        bfs(1);
        bfs(farthestNode);

        bufferedWriter.write(maxDist + "\n");

        bufferedWriter.flush();

    }

    static void bfs(int start) {

        Queue<int[]> queue = new LinkedList<>();

        visited = new boolean[tree.length];
        maxDist = 0;
        farthestNode = start;

        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int node = cur[0];
            int dist = cur[1];

            if (dist > maxDist) {
                maxDist = dist;
                farthestNode = node;
            }

            for (Edge el: tree[node]) {
                if (!visited[el.to]) {
                    visited[el.to] = true;
                    queue.offer(new int[]{el.to, dist + el.weight});
                }
            }
        }
    }
}