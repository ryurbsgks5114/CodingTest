import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {

        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }

    static List<Edge>[] graph;
    static int[] dist;
    static int[] prev;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            graph[from].add(new Edge(to, cost));
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());

        dijkstra(start);

        bufferedWriter.write(dist[end] + "\n");

        List<Integer> path = new ArrayList<>();
        
        for (int i = end; i != 0; i = prev[i]) {
            path.add(i);
        }
        
        Collections.reverse(path);

        bufferedWriter.write(path.size() + "\n");

        for (int el: path) {
            bufferedWriter.write(el + " ");
        }

        bufferedWriter.flush();

    }

    static void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {

            Edge cur = pq.poll();

            if (cur.cost > dist[cur.to]) {
                continue;
            }

            for (Edge el: graph[cur.to]) {

                int newDist = dist[cur.to] + el.cost;

                if (newDist < dist[el.to]) {
                    dist[el.to] = newDist;
                    prev[el.to] = cur.to;
                    pq.offer(new Edge(el.to, newDist));
                }
            }
        }
    }
}