import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int pack = Integer.parseInt(stringTokenizer.nextToken());
            int single = Integer.parseInt(stringTokenizer.nextToken());

            minPackage = Math.min(minPackage, pack);
            minSingle = Math.min(minSingle, single);
        }

        int costA = ((N + 5) / 6) * minPackage;

        int costB = N * minSingle;

        int costC = (N / 6) * minPackage + Math.min((N % 6) * minSingle, minPackage);

        int answer = Math.min(costA, Math.min(costB, costC));

        bufferedWriter.write(answer + "\n");

        bufferedWriter.flush();

    }
}