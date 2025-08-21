import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int D = Integer.parseInt(stringTokenizer.nextToken());
        int H = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());

        double k = D / Math.sqrt(H * H + W * W);

        int h = (int)(H * k);
        int w = (int)(W * k);

        bufferedWriter.write(h + " " + w + "\n");

        bufferedWriter.flush();

    }
}