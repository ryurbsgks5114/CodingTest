import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word;

        while ((word = bufferedReader.readLine()) != null) {
            bufferedWriter.write(word);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}