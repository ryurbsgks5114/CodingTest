import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String num = stringTokenizer.nextToken();
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int len = num.length();

        if (len == 1 || (len == 2 && num.charAt(1) == '0' && K > 0)) {
            bufferedWriter.write("-1\n");
            bufferedWriter.flush();

            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String>[] visited = new HashSet[K + 1];

        for (int i = 0; i <= K; i++) {
            visited[i] = new HashSet<>();
        }

        queue.add(num);
        visited[0].add(num);

        for (int i = 1; i <= K; i++) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {

                String current = queue.poll();
                char[] arr = current.toCharArray();

                for (int k = 0; k < len - 1; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if (k == 0 && arr[l] == '0') {
                            continue;
                        }

                        char temp = arr[k];
                        arr[k] = arr[l];
                        arr[l] = temp;

                        String next = new String(arr);

                        if (!visited[i].contains(next)) {
                            visited[i].add(next);
                            queue.add(next);
                        }

                        temp = arr[k];
                        arr[k] = arr[l];
                        arr[l] = temp;
                    }
                }
            }
        }

        if (visited[K].isEmpty()) {
            bufferedWriter.write("-1\n");
        } else {
            int max = 0;

            for (String el: visited[K]) {
                max = Math.max(max, Integer.parseInt(el));
            }

            bufferedWriter.write(max + "\n");
        }

        bufferedWriter.flush();

    }
}