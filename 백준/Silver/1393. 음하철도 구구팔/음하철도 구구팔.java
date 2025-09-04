import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long xs = Long.parseLong(stringTokenizer.nextToken());
        long ys = Long.parseLong(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long xe = Long.parseLong(stringTokenizer.nextToken());
        long ye = Long.parseLong(stringTokenizer.nextToken());
        long dx = Long.parseLong(stringTokenizer.nextToken());
        long dy = Long.parseLong(stringTokenizer.nextToken());

        long q = dx * dx + dy * dy;

        if (q == 0) {
            bufferedWriter.write(xe + " " + ye + "\n");
            bufferedWriter.flush();

            return;
        }

        long p = -((xe - xs) * dx + (ye - ys) * dy);

        if (p < 0) {
            bufferedWriter.write(xe + " " + ye + "\n");
        } else {

            long xNumer = xe * q + dx * p;
            long yNumer = ye * q + dy * p;
            long x = xNumer / q;
            long y = yNumer / q;

            bufferedWriter.write(x + " " + y + "\n");
        }

        bufferedWriter.flush();

    }
}