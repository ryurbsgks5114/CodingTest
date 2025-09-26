import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] seen = new boolean[C + 1];

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(bufferedReader.readLine().trim());

            for (int j = p; j <= C; j += p) {
                seen[j] = true;
            }
        }

        int answer = 0;

        for (int i = 1; i <= C; i++) {
            if (seen[i]) {
                answer++;
            }
        }

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();

    }
}