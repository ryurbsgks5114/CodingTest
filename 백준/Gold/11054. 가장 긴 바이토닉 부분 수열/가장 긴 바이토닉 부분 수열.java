import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] A = new int[n];
        int[] inc = new int[n];
        int[] dec = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < n; i++) {
            inc[i] = 1;

            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;

            for (int j = n - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        int max = 0;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, inc[i] + dec[i] - 1);
        }

        bufferedWriter.write(max + "\n");

        bufferedWriter.flush();

    }
}