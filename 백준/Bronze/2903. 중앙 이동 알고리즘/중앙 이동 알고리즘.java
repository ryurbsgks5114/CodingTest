import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int side = (int) Math.pow(2, N) + 1;
        int total = side * side;

        bufferedWriter.write(String.valueOf(total));

        bufferedWriter.flush();

    }
}