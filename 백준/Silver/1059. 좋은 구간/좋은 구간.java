import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(bufferedReader.readLine());
        int[] S = new int[L];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int n = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(S);

        for (int s: S) {
            if (s == n) {
                bufferedWriter.write("0\n");
                bufferedWriter.flush();

                return;
            }
        }

        int low = 0;
        int high = 1001;

        for (int s: S) {
            if (s < n) {
                low = Math.max(low, s);
            } else if (s > n) {
                high = Math.min(high, s);

                break;
            }
        }

        int result = (n - low) * (high - n) - 1;
        
        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}