import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        bufferedWriter.write(String.valueOf((long) n * (n - 1) * (n - 2) / 6));
        bufferedWriter.newLine();
        bufferedWriter.write("3");

        bufferedWriter.flush();

    }
}