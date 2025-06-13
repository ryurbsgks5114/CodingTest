import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, Integer> map;
    static int[] parent, size;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < T; t++) {

            int F = Integer.parseInt(bufferedReader.readLine());

            map = new HashMap<>();
            parent = new int[200000];
            size = new int[200000];
            int idx = 0;

            for (int i = 0; i < 200000; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < F; i++) {

                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String f1 = stringTokenizer.nextToken();
                String f2 = stringTokenizer.nextToken();

                if (!map.containsKey(f1)) {
                    map.put(f1, idx++);
                }

                if (!map.containsKey(f2)) {
                    map.put(f2, idx++);
                }

                int a = map.get(f1);
                int b = map.get(f2);
                int networkSize = union(a, b);

                bufferedWriter.write(networkSize + "\n");
            }
        }

        bufferedWriter.flush();

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

    static int union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return size[rootA];
        }

        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];

            return size[rootB];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
            
            return size[rootA];
        }
    }
}