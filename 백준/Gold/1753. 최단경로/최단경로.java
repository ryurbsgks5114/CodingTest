import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int V = Integer.parseInt(stringTokenizer.nextToken());
        int E = Integer.parseInt(stringTokenizer.nextToken());

        int start = Integer.parseInt(bufferedReader.readLine());

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {

            Edge cur = pq.poll();
            int now = cur.to;
            int cost = cur.weight;

            if (dist[now] < cost) {
                continue;
            }

            for (Edge el: graph.get(now)) {
                
                int newDist = dist[now] + el.weight;

                if (newDist < dist[el.to]) {
                    dist[el.to] = newDist;
                    pq.offer(new Edge(el.to, newDist));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                bufferedWriter.write("INF\n");
            } else {
                bufferedWriter.write(dist[i] + "\n");
            }
        }

        bufferedWriter.flush();

    }

    static class Edge implements Comparable<Edge> {

        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}