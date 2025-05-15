import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            graph[A].add(B);
            indegree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int curr = queue.poll();

            stringBuilder.append(curr).append(" ");

            for (int el: graph[curr]) {
                indegree[el]--;

                if (indegree[el] == 0) {
                    queue.add(el);
                }
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        
        bufferedWriter.flush();

    }
}