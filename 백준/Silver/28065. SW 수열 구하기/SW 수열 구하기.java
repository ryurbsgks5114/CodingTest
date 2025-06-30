import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] res = new int[N];
        int low = 1;
        int high = N;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                res[i] = high--;
            } else {
                res[i] = low++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int el: res) {
            stringBuilder.append(el).append(" ");
        }

        bufferedWriter.write(stringBuilder + "\n");

        bufferedWriter.flush();

    }
}