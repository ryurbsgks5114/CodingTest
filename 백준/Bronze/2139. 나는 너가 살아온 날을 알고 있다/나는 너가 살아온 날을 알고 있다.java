import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer;

        while (true) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            if (d == 0 && m == 0 && y == 0) {
                break;
            }

            int[] days = { 31,28,31,30,31,30,31,31,30,31,30,31 };

            if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)) {
                days[1] = 29;
            }

            int total = 0;
            
            for (int i = 0; i < m - 1; i++) {
                total += days[i];
            }
            
            total += d;

            bufferedWriter.write(total + "\n");
        }

        bufferedWriter.flush();

    }
}