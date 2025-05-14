import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] color;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(bufferedReader.readLine());

        while (K-- > 0) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int V = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());

            graph = new ArrayList[V + 1];
            color = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int u = Integer.parseInt(stringTokenizer.nextToken());
                int v = Integer.parseInt(stringTokenizer.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    bfs(i);
                }
            }

            bufferedWriter.write((isBipartite ? "YES" : "NO") + "\n");
        }
        
        bufferedWriter.flush();

    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        color[start] = 1;

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int el: graph[curr]) {
                if (color[el] == 0) {
                    color[el] = -color[curr];
                    q.add(el);
                } else if (color[el] == color[curr]) {
                    isBipartite = false;

                    return;
                }
            }
        }
    }
}