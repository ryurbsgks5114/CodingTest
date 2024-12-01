import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int count = 0;
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {

                count++;

                if (count == K) {
                    result = i;

                    break;
                }
            }
        }

        if (count < K) {
            bufferedWriter.write("0");
        } else {
            bufferedWriter.write(String.valueOf(result));
        }

        bufferedWriter.flush();

    }
}