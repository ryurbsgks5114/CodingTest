import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(A).add(B);
            indegree[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {

            int now = pq.poll();

            result.add(now);

            for (int el: graph.get(now)) {
                indegree[el]--;

                if (indegree[el] == 0) {
                    pq.offer(el);
                }
            }
        }

        for (int el: result) {
            bufferedWriter.write(el + " ");
        }

        bufferedWriter.write("\n");

        bufferedWriter.flush();

    }
}