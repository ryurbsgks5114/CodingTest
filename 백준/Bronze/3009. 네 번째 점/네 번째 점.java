import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            x[i] = Integer.parseInt(input[0]);
            y[i] = Integer.parseInt(input[1]);

        }

        int x4 = (x[0] == x[1]) ? x[2] : (x[0] == x[2]) ? x[1] : x[0];
        int y4 = (y[0] == y[1]) ? y[2] : (y[0] == y[2]) ? y[1] : y[0];

        bufferedWriter.write(x4 + " " + y4);

        bufferedWriter.flush();

    }
}