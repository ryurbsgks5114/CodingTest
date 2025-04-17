import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Jewel[] jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int m = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());

            jewels[i] = new Jewel(m, v);
        }

        int[] bags = new int[K];

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        long total = 0;
        int j = 0;

        for (int i = 0; i < K; i++) {

            int capacity = bags[i];

            while (j < N && jewels[j].weight <= capacity) {
                priorityQueue.offer(jewels[j].price);
                j++;
            }

            if (!priorityQueue.isEmpty()) {
                total += priorityQueue.poll();
            }
        }

        bufferedWriter.write(total + "\n");

        bufferedWriter.flush();

    }

    static class Jewel implements Comparable<Jewel> {

        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight;
        }
    }
}