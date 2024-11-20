import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] array = new int[9][9];
        int maxValue = 0;
        int maxRow = 1;
        int maxCol = 1;

        for (int i = 0; i < 9; i++) {

            String[] row = bufferedReader.readLine().split(" ");

            for (int j = 0; j < 9; j++) {

                array[i][j] = Integer.parseInt(row[j]);

                if (array[i][j] > maxValue) {

                    maxValue = array[i][j];
                    maxRow = i + 1;
                    maxCol = j + 1;

                }

            }

        }

        bufferedWriter.write(String.valueOf(maxValue));
        bufferedWriter.newLine();
        bufferedWriter.write(maxRow + " " + maxCol);

        bufferedWriter.flush();

    }
}