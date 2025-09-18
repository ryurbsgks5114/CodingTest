import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);
        int[] count = new int[N];
        int pos = 0;
        int throwCount = 0;

        count[0] = 1;

        while (count[pos] < M) {
            if (count[pos] % 2 == 1) {
                pos = (pos + L) % N;
            } else {
                pos = (pos - L + N) % N;
            }

            count[pos]++;
            throwCount++;
        }

        bufferedWriter.write(throwCount + "\n");

        bufferedWriter.flush();

    }
}