import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String hex = bufferedReader.readLine().trim();
        int decimal = Integer.parseInt(hex, 16);

        bufferedWriter.write(decimal + "\n");

        bufferedWriter.flush();

    }
}