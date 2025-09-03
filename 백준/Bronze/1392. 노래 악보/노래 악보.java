import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int Q = Integer.parseInt(stringTokenizer.nextToken());

        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] C = new int[N];
        C[0] = B[0];

        for (int i = 1; i < N; i++) {
            C[i] = C[i-1] + B[i];
        }

        for (int i = 0; i < Q; i++) {

            int T = Integer.parseInt(bufferedReader.readLine());
            int idx = 0;

            while (idx < N && T >= C[idx]) {
                idx++;
            }

            bufferedWriter.write((idx + 1) + "\n");
        }

        bufferedWriter.flush();

    }
}