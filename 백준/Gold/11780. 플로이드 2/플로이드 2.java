import java.io.*;
import java.util.*;

public class Main {

    static int[][] dist;
    static int[][] path;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        int INF = 1_000_000_000;

        dist = new int[n + 1][n + 1];
        path = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            if (cost < dist[from][to]) {
                dist[from][to] = cost;
                path[from][to] = from;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dist[j][i] + dist[i][k] < dist[j][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                        path[j][k] = path[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bufferedWriter.write((dist[i][j] == INF ? 0 : dist[i][j]) + " ");
            }

            bufferedWriter.write("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF || i == j) {
                    bufferedWriter.write("0\n");

                    continue;
                }

                List<Integer> route = new ArrayList<>();
                buildPath(i, j, route);
                route.add(j);

                bufferedWriter.write(route.size() + " ");

                for (int el: route) {
                    bufferedWriter.write(el + " ");
                }

                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.flush();

    }

    static void buildPath(int i, int j, List<Integer> route) {
        if (i == path[i][j]) {
            route.add(i);

            return;
        }

        buildPath(i, path[i][j], route);
        route.add(path[i][j]);
    }
}