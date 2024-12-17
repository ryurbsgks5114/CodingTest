import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        bufferedWriter.write(String.valueOf((long) n * (n - 1) / 2));
        bufferedWriter.newLine();
        bufferedWriter.write("2");

        bufferedWriter.flush();

    }
}