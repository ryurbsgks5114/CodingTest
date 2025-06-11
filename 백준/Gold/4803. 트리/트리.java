import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean isTree;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer;
        int caseNum = 1;

        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];

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

            int treeCount = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    isTree = true;
                    dfs(i, 0);

                    if (isTree) {
                        treeCount++;
                    }
                }
            }

            bufferedWriter.write("Case " + caseNum + ": ");

            if (treeCount == 0) {
                bufferedWriter.write("No trees.\n");
            } else if (treeCount == 1) {
                bufferedWriter.write("There is one tree.\n");
            } else {
                bufferedWriter.write("A forest of " + treeCount + " trees.\n");
            }

            caseNum++;
        }

        bufferedWriter.flush();

    }

    static void dfs(int curr, int parent) {
        visited[curr] = true;

        for (int el: graph[curr]) {
            if (el == parent) {
                continue;
            }

            if (visited[el]) {
                isTree = false;
                continue;
            }

            dfs(el, curr);
        }
    }
}