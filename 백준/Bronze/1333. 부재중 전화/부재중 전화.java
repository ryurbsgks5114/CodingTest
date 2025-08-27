import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int D = Integer.parseInt(input[2]);

        int albumEnd = N * L + (N - 1) * 5;

        for (int i = 0; ; i += D) {
            if (i >= albumEnd) {
                bufferedWriter.write(i + "\n");

                break;
            }

            boolean canHear = true;

            for (int j = 0; j < N; j++) {

                int start = j * (L + 5);
                int end = start + L;

                if (i >= start && i < end) {
                    canHear = false;

                    break;
                }
            }

            if (canHear) {
                bufferedWriter.write(i + "\n");
                
                break;
            }
        }

        bufferedWriter.flush();

    }
}