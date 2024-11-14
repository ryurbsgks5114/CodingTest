import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();
        String reverseWord = new StringBuilder(word).reverse().toString();

        if (word.equals(reverseWord)) {
            bufferedWriter.write("1");
        } else {
            bufferedWriter.write("0");
        }

        bufferedWriter.flush();

    }
}