import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < T; i++) {
            String line;

            while ((line = bufferedReader.readLine()) != null && line.trim().isEmpty());

            StringTokenizer stringTokenizer = new StringTokenizer(line);
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int maxS = 0;
            int maxB = 0;

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                maxS = Math.max(maxS, Integer.parseInt(stringTokenizer.nextToken()));
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < M; j++) {
                maxB = Math.max(maxB, Integer.parseInt(stringTokenizer.nextToken()));
            }

            if (maxS >= maxB) {
                bufferedWriter.write("S\n");
            } else {
                bufferedWriter.write("B\n");
            }
        }

        bufferedWriter.flush();

    }
}