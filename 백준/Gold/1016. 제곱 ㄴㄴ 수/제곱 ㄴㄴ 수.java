import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);

        int size = (int) (max - min + 1);
        boolean[] isNotSquareFree = new boolean[size];

        for (long i = 2; i * i <= max; i++) {

            long square = i * i;
            long start = ((min + square - 1) / square) * square;

            for (long j = start; j <= max; j += square) {
                isNotSquareFree[(int)(j - min)] = true;
            }
        }

        int count = 0;

        for (int i = 0; i < size; i++) {
            if (!isNotSquareFree[i]) {
                count++;
            }
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }
}