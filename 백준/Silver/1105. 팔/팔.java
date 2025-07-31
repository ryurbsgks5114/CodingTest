import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int minCount = Integer.MAX_VALUE;

        for (int i = L; i <= R; i++) {
            int count = countEights(i);

            if (count < minCount) {
                minCount = count;

                if (minCount == 0) {
                    break;
                }
            }
        }

        bufferedWriter.write(String.valueOf(minCount));

        bufferedWriter.flush();

    }

    private static int countEights(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 10 == 8) {
                count++;
            }

            num /= 10;
        }

        return count;
    }
}