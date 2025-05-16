import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {

            int n = Integer.parseInt(bufferedReader.readLine());
            int[] lastYear = new int[n];
            int[][] graph = new int[n + 1][n + 1];
            int[] indegree = new int[n + 1];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 0; i < n; i++) {
                lastYear[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    int higher = lastYear[i];
                    int lower = lastYear[j];

                    graph[higher][lower] = 1;
                    indegree[lower]++;
                }
            }

            int m = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < m; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                if (graph[a][b] == 1) {
                    graph[a][b] = 0;
                    graph[b][a] = 1;
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[b][a] = 0;
                    graph[a][b] = 1;
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }

            List<Integer> result = new ArrayList<>();
            boolean certain = true;
            boolean cycle = false;

            for (int i = 0; i < n; i++) {
                if (queue.isEmpty()) {
                    cycle = true;

                    break;
                }

                if (queue.size() > 1) {
                    certain = false;
                }

                int curr = queue.poll();
                result.add(curr);

                for (int j = 1; j <= n; j++) {
                    if (graph[curr][j] == 1) {
                        indegree[j]--;

                        if (indegree[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
            }

            if (cycle) {
                bufferedWriter.write("IMPOSSIBLE\n");
            } else if (!certain) {
                bufferedWriter.write("?\n");
            } else {
                for (int el: result) {
                    bufferedWriter.write(el + " ");
                }
                
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.flush();

    }
}