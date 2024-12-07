import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);

        int left = x;
        int right = w - x;
        int bottom = y;
        int top = h - y;

        int distance = Math.min(Math.min(left, bottom), Math.min(right, top));

        bufferedWriter.write(String.valueOf(distance));

        bufferedWriter.flush();

    }
}