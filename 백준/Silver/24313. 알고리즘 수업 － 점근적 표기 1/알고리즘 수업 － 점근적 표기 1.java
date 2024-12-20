import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int a1 = Integer.parseInt(input[0]);
        int a0 = Integer.parseInt(input[1]);
        int c = Integer.parseInt(bufferedReader.readLine());
        int n0 = Integer.parseInt(bufferedReader.readLine());

        boolean condition1 = a1 <= c;
        boolean condition2 = (a1 - c) * n0 + a0 <= 0;

        bufferedWriter.write(condition1 && condition2 ? "1" : "0");

        bufferedWriter.flush();

    }
}