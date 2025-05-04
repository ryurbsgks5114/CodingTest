import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n + 1];

        dfs(start);

        sb.append("\n");

        visited = new boolean[n + 1];

        bfs(start);

        bufferedWriter.write(sb + "\n");

        bufferedWriter.flush();

    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int el: graph[node]) {
            if (!visited[el]) {
                dfs(el);
            }
        }
    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            sb.append(node).append(" ");

            for (int el: graph[node]) {
                if (!visited[el]) {
                    visited[el] = true;
                    queue.offer(el);
                }
            }
        }
    }
}