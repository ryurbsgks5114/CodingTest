import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] P = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(P);

        int sum = 0;
        int total = 0;

        for (int el : P) {
            sum += el;
            total += sum;
        }

        bufferedWriter.write(String.valueOf(total));

        bufferedWriter.flush();

    }
}