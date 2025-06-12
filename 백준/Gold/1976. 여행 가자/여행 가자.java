import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 1; j <= N; j++) {

                int connected = Integer.parseInt(stringTokenizer.nextToken());

                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int firstCity = Integer.parseInt(stringTokenizer.nextToken());
        int root = find(firstCity);
        boolean isPossible = true;

        for (int i = 1; i < M; i++) {

            int city = Integer.parseInt(stringTokenizer.nextToken());

            if (find(city) != root) {
                isPossible = false;

                break;
            }
        }

        bufferedWriter.write(isPossible ? "YES\n" : "NO\n");

        bufferedWriter.flush();

    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}