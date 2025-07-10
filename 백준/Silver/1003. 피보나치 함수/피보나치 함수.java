import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());
        int[] count0 = new int[41];
        int[] count1 = new int[41];

        count0[0] = 1;
        count1[0] = 0;
        count0[1] = 0;
        count1[1] = 1;

        for (int i = 2; i <= 40; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bufferedReader.readLine());

            bufferedWriter.write(count0[n] + " " + count1[n] + "\n");
        }

        bufferedWriter.flush();

    }
}