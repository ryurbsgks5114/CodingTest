import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();
        String[] alphabets = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        for (String el: alphabets) {
            word = word.replace(el, "1");
        }

        bufferedWriter.write(String.valueOf(word.length()));

        bufferedWriter.flush();

    }
}