import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < T; t++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int r1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            int r2 = Integer.parseInt(stringTokenizer.nextToken());
            int dx = x1 - x2;
            int dy = y1 - y2;
            int dSquared = dx * dx + dy * dy;
            int rSum = r1 + r2;
            int rDiff = Math.abs(r1 - r2);
            int rSumSquared = rSum * rSum;
            int rDiffSquared = rDiff * rDiff;
            int result;

            if (dSquared == 0) {
                if (r1 == r2) {
                    result = -1;
                } else {
                    result = 0;
                }
            } else {
                if (dSquared > rSumSquared) {
                    result = 0;
                } else if (dSquared == rSumSquared) {
                    result = 1;
                } else if (dSquared > rDiffSquared) {
                    result = 2;
                } else if (dSquared == rDiffSquared) {
                    result = 1;
                } else {
                    result = 0;
                }
            }

            bufferedWriter.write(result + "\n");
        }

        bufferedWriter.flush();

    }
}