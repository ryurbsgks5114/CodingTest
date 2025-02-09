import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (stringTokenizer.hasMoreTokens()) {

            int num = Integer.parseInt(stringTokenizer.nextToken());

            min = Math.min(min, num);
            max = Math.max(max, num);

        }

        bufferedWriter.write(String.valueOf(min * max));

        bufferedWriter.flush();

    }
}