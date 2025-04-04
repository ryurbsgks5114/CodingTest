import java.io.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(bufferedReader.readLine());

        long[][] baseMatrix = {{1, 1}, {1, 0}};

        long[][] resultMatrix = matrixPower(baseMatrix, n - 1);

        bufferedWriter.write(String.valueOf(resultMatrix[0][0]));
        
        bufferedWriter.flush();

    }

    static long[][] matrixPower(long[][] matrix, long exp) {
        
        long[][] identity = {{1, 0}, {0, 1}};

        while (exp > 0) {
            if (exp % 2 == 1) {
                identity = multiplyMatrix(identity, matrix);
            }
            
            matrix = multiplyMatrix(matrix, matrix);
            exp /= 2;
        }

        return identity;
    }

    static long[][] multiplyMatrix(long[][] mat1, long[][] mat2) {
        
        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + mat1[i][k] * mat2[k][j]) % MOD;
                }
            }
        }

        return result;
    }
}