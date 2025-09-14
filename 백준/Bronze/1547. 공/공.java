import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bufferedReader.readLine());
        int ballCup = 1;

        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (ballCup == X) {
                ballCup = Y;
            } else if (ballCup == Y) {
                ballCup = X;
            }
        }

        bufferedWriter.write(ballCup + "\n");

        bufferedWriter.flush();

    }
}