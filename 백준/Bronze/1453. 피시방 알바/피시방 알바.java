import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        boolean[] seat = new boolean[101];
        int rejected = 0;

        for (int i = 0; i < N; i++) {
            int want = Integer.parseInt(stringTokenizer.nextToken());

            if (seat[want]) {
                rejected++;
            } else {
                seat[want] = true;
            }
        }

        bufferedWriter.write(rejected + "\n");

        bufferedWriter.flush();

    }
}