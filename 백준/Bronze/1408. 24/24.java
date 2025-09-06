import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] cur = bufferedReader.readLine().split(":");
        String[] start = bufferedReader.readLine().split(":");

        int curSec = Integer.parseInt(cur[0]) * 3600 + Integer.parseInt(cur[1]) * 60 + Integer.parseInt(cur[2]);
        int startSec = Integer.parseInt(start[0]) * 3600 + Integer.parseInt(start[1]) * 60 + Integer.parseInt(start[2]);
        int remain = (startSec - curSec + 86400) % 86400;

        int h = remain / 3600;
        int m = (remain % 3600) / 60;
        int s = remain % 60;

        bufferedWriter.write(String.format("%02d:%02d:%02d\n", h, m, s));

        bufferedWriter.flush();

    }
}