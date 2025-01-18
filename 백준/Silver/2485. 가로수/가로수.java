import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] positions = new int[N];

        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] gaps = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            gaps[i] = positions[i + 1] - positions[i];
        }

        int gcd = gaps[0];

        for (int i = 1; i < gaps.length; i++) {
            gcd = GCD(gcd, gaps[i]);
        }

        int addTrees = 0;

        for (int gap: gaps) {
            addTrees = addTrees + (gap / gcd) - 1;
        }

        bufferedWriter.write(String.valueOf(addTrees));

        bufferedWriter.flush();

    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }
}