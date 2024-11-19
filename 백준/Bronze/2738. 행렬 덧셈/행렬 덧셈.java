import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++) {

            String[] row = bufferedReader.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(row[j]);
            }

        }

        for (int i = 0; i < N; i++) {

            String[] row = bufferedReader.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(row[j]);
            }

        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {
                bufferedWriter.write((A[i][j] + B[i][j]) + " ");
            }

            bufferedWriter.newLine();

        }

        bufferedWriter.flush();

    }
}