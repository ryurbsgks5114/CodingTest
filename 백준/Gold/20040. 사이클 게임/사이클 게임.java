import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;

        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            if (find(a) == find(b)) {
                answer = i;

                break;
            }

            union(a, b);
        }

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

    static boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return true;
        }

        parent[rootB] = rootA;

        return false;
    }
}