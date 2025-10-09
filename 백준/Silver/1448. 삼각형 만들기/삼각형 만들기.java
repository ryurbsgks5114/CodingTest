import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] straws = new int[N];

        for (int i = 0; i < N; i++) {
            straws[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(straws);

        int result = -1;

        for (int i = N - 1; i >= 2; i--) {

            int a = straws[i];
            int b = straws[i - 1];
            int c = straws[i - 2];

            if (b + c > a) {
                result = a + b + c;
                
                break;
            }
        }

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}