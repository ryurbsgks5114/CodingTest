import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] S;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        backtrack(0, 0);

        bufferedWriter.write(minDiff + "\n");

        bufferedWriter.flush();

    }

    public static void backtrack(int index, int count) {
        if (count == N / 2) {
            calculateTeamDifference();

            return;
        }

        for (int i = index; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                backtrack(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    public static void calculateTeamDifference() {

        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) {
                    startSum = startSum + S[i][j];
                } else if (!selected[i] && !selected[j]) {
                    linkSum = linkSum + S[i][j];
                }
            }
        }

        minDiff = Math.min(minDiff, Math.abs(startSum - linkSum));
    }
}