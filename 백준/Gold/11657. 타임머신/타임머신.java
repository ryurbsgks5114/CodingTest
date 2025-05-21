import java.io.*;
import java.util.*;

public class Main {

    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int time = Integer.parseInt(stringTokenizer.nextToken());

            edges.add(new Edge(from, to, time));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        boolean negativeCycle = false;

        for (int i = 1; i <= N; i++) {
            for (Edge el: edges) {
                if (dist[el.from] != INF && dist[el.to] > dist[el.from] + el.time) {
                    dist[el.to] = dist[el.from] + el.time;

                    if (i == N) {
                        negativeCycle = true;
                    }
                }
            }
        }

        if (negativeCycle) {
            bufferedWriter.write("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    bufferedWriter.write("-1\n");
                } else {
                    bufferedWriter.write(dist[i] + "\n");
                }
            }
        }

        bufferedWriter.flush();

    }

    static class Edge {

        int from, to, time;

        Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
}