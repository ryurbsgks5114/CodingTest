import java.io.*;

public class Main {

    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        bufferedWriter.write((1 << N) - 1 + "\n");

        hanoi(N, 1, 3, 2);

        bufferedWriter.flush();

    }

    public static void hanoi(int n, int from, int to, int via) throws IOException {
        if (n == 1) {
            bufferedWriter.write(from + " " + to + "\n");

            return;
        }

        hanoi(n - 1, from, via, to);

        bufferedWriter.write(from + " " + to + "\n");

        hanoi(n - 1, via, to, from);

    }
}