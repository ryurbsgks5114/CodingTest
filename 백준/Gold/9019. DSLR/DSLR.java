import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int target = Integer.parseInt(stringTokenizer.nextToken());

            Arrays.fill(visited, false);
            bufferedWriter.write(bfs(start, target) + "\n");
        }

        bufferedWriter.flush();

    }

    static String bfs(int start, int target) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, ""));
        visited[start] = true;

        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            int n = curr.num;
            String seq = curr.seq;

            if (n == target) {
                return seq;
            }

            int d = (2 * n) % 10000;

            if (!visited[d]) {
                visited[d] = true;
                queue.offer(new Node(d, seq + "D"));
            }

            int s = (n == 0) ? 9999 : n - 1;

            if (!visited[s]) {
                visited[s] = true;
                queue.offer(new Node(s, seq + "S"));
            }

            int l = (n % 1000) * 10 + (n / 1000);

            if (!visited[l]) {
                visited[l] = true;
                queue.offer(new Node(l, seq + "L"));
            }

            int r = (n % 10) * 1000 + (n / 10);

            if (!visited[r]) {
                visited[r] = true;
                queue.offer(new Node(r, seq + "R"));
            }
        }

        return "";
    }

    static class Node {

        int num;
        String seq;

        Node(int num, String seq) {
            this.num = num;
            this.seq = seq;
        }
    }
}