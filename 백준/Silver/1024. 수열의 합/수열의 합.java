import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        boolean check = false;

        for (int i = L; i <= 100; i++) {
            int temp = N - (i * (i - 1)) / 2;

            if (temp < 0) {
                break;
            }

            if (temp % i == 0) {
                int x = temp / i;

                for (int j = 0; j < i; j++) {
                    bufferedWriter.write((x + j) + " ");
                }

                bufferedWriter.write("\n");
                check = true;

                break;
            }
        }

        if (!check) {
            bufferedWriter.write("-1\n");
        }

        bufferedWriter.flush();

    }
}