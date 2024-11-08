import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        char input = bufferedReader.readLine().charAt(0);
        int asciiCode = (int) input;

        bufferedWriter.write(String.valueOf(asciiCode));

        bufferedWriter.flush();

    }
}