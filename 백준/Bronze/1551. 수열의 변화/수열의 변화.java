import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        String[] arrStr = bufferedReader.readLine().split(",");
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(arrStr[i]);
        }

        for (int i = 0; i < K; i++) {
            int[] B = new int[A.length - 1];

            for (int j = 0; j < B.length; j++) {
                B[j] = A[j + 1] - A[j];
            }

            A = B;
        }

        for (int i = 0; i < A.length; i++) {
            bufferedWriter.write(A[i] + (i == A.length - 1 ? "" : ","));
        }

        bufferedWriter.write("\n");

        bufferedWriter.flush();

    }
}