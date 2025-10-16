import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(arr);

        long dissatisfaction = 0;
        
        for (int i = 0; i < N; i++) {
            dissatisfaction += Math.abs(arr[i] - (i + 1));
        }

        bufferedWriter.write(String.valueOf(dissatisfaction));

        bufferedWriter.flush();

    }
}