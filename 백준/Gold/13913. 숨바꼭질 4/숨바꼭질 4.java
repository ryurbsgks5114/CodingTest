import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] time = new int[MAX];
        int[] prev = new int[MAX];

        Arrays.fill(time, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now == K) {
                break;
            }

            for (int el: new int[]{now - 1, now + 1, now * 2}) {
                if (el >= 0 && el < MAX && time[el] == -1) {
                    queue.add(el);
                    time[el] = time[now] + 1;
                    prev[el] = now;
                }
            }
        }

        bufferedWriter.write(time[K] + "\n");

        Stack<Integer> stack = new Stack<>();

        int current = K;

        while (current != N) {
            stack.push(current);
            current = prev[current];
        }

        stack.push(N);

        while (!stack.isEmpty()) {
            bufferedWriter.write(stack.pop() + " ");
        }

        bufferedWriter.flush();

    }
}