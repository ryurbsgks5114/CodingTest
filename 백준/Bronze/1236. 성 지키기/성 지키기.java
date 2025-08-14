import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] rowHasGuard = new boolean[N];
        boolean[] colHasGuard = new boolean[M];

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'X') {
                    rowHasGuard[i] = true;
                    colHasGuard[j] = true;
                }
            }
        }

        int emptyRows = 0;

        for (boolean el: rowHasGuard) {
            if (!el) {
                emptyRows++;
            }
        }

        int emptyCols = 0;

        for (boolean el: colHasGuard) {
            if (!el) {
                emptyCols++;
            }
        }

        bufferedWriter.write(String.valueOf(Math.max(emptyRows, emptyCols)));

        bufferedWriter.flush();

    }
}