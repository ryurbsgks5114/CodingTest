import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());

        long left = 1;
        long right = (long) N * N;
        long answer = 0;

        while (left <= right) {
            
            long mid = (left + right) / 2;
            long count = 0;
            
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bufferedWriter.write(answer + "\n");

        bufferedWriter.flush();

    }
}