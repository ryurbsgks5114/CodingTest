import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        long X = Long.parseLong(input[0]);
        long Y = Long.parseLong(input[1]);
        long Z = (Y * 100) / X;

        if (Z >= 99) {
            bufferedWriter.write("-1\n");
        } else {

            long left = 1;
            long right = 1_000_000_000;
            long answer = -1;

            while (left <= right) {

                long mid = (left + right) / 2;
                long newZ = ((Y + mid) * 100) / (X + mid);

                if (newZ > Z) {
                    answer = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            bufferedWriter.write(answer + "\n");
        }

        bufferedWriter.flush();

    }
}