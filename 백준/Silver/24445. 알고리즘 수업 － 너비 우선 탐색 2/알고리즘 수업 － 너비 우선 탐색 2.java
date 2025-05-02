import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        order = new int[n + 1];

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
            graph[i].sort(Comparator.reverseOrder());
        }

        bfs(r);

        for (int i = 1; i <= n; i++) {
            bufferedWriter.write(order[i] + "\n");
        }

        bufferedWriter.flush();

    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        order[start] = cnt++;
        queue.offer(start);

        while (!queue.isEmpty()) {

            int curr = queue.poll();

            for (int el: graph[curr]) {
                if (!visited[el]) {
                    visited[el] = true;
                    order[el] = cnt++;
                    queue.offer(el);
                }
            }
        }
    }
}