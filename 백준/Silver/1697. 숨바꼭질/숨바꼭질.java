import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int start = Integer.parseInt(stringTokenizer.nextToken());
        int target = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] visited = new boolean[MAX];
        int[] time = new int[MAX];
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        
        visited[start] = true;

        while (!queue.isEmpty()) {
            
            int now = queue.poll();

            if (now == target) {
                bufferedWriter.write(time[now] + "\n");
                bufferedWriter.flush();
                
                return;
            }

            int[] nextPositions = { now - 1, now + 1, now * 2 };

            for (int el: nextPositions) {
                if (el >= 0 && el < MAX && !visited[el]) {
                    queue.offer(el);
                    visited[el] = true;
                    time[el] = time[now] + 1;
                }
            }
        }

    }
}