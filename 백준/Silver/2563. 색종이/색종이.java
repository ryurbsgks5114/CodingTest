import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] array = new boolean[100][100];

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    array[j][k] = true;
                }
            }

        }

        int answer = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (array[i][j]) {
                    answer++;
                }
            }
        }

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();

    }
}