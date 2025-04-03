import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] A;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(stringTokenizer.nextToken()) % MOD;
            }
        }

        int[][] result = matrixPower(A, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bufferedWriter.write(result[i][j] + " ");
            }
            
            bufferedWriter.write("\n");
        }


        bufferedWriter.flush();

    }

    static int[][] matrixPower(int[][] matrix, long exp) {

        int[][] identity = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            identity[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 == 1) {
                identity = multiplyMatrix(identity, matrix);
            }
            
            matrix = multiplyMatrix(matrix, matrix);
            exp /= 2;
        }

        return identity;
    }

    static int[][] multiplyMatrix(int[][] mat1, int[][] mat2) {
        
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] = (result[i][j] + mat1[i][k] * mat2[k][j]) % MOD;
                }
            }
        }

        return result;
    }
}