import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());
            int[] buildTime = new int[N + 1];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            List<Integer>[] graph = new ArrayList[N + 1];

            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] indegree = new int[N + 1];

            for (int i = 0; i < K; i++) {

                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int from = Integer.parseInt(stringTokenizer.nextToken());
                int to = Integer.parseInt(stringTokenizer.nextToken());

                graph[from].add(to);
                indegree[to]++;
            }

            int target = Integer.parseInt(bufferedReader.readLine());
            int[] resultTime = new int[N + 1];
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    resultTime[i] = buildTime[i];
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int el: graph[now]) {
                    resultTime[el] = Math.max(resultTime[el], resultTime[now] + buildTime[el]);
                    indegree[el]--;
                    
                    if (indegree[el] == 0) {
                        queue.offer(el);
                    }
                }
            }

            bufferedWriter.write(resultTime[target] + "\n");
        }

        bufferedWriter.flush();

    }
}