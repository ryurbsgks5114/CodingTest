import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int[] seq = new int[B + 1];
        int idx = 1;

        for (int i = 1; idx <= B; i++) {
            for (int j = 0; j < i && idx <= B; j++) {
                seq[idx++] = i;
            }
        }

        int sum = 0;

        for (int i = A; i <= B; i++) {
            sum += seq[i];
        }

        bufferedWriter.write(String.valueOf(sum));

        bufferedWriter.flush();

    }
}