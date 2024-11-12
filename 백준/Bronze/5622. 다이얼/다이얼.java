import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();

        int second = 0;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if ('A' <= ch && ch <= 'C') {
                second = second + 3;
            } else if ('D' <= ch && ch <= 'F') {
                second = second + 4;
            } else if ('G' <= ch && ch <= 'I') {
                second = second + 5;
            } else if ('J' <= ch && ch <= 'L') {
                second = second + 6;
            } else if ('M' <= ch && ch <= 'O') {
                second = second + 7;
            } else if ('P' <= ch && ch <= 'S') {
                second = second + 8;
            } else if ('T' <= ch && ch <= 'V') {
                second = second + 9;
            } else {
                second = second + 10;
            }

        }

        bufferedWriter.write(String.valueOf(second));

        bufferedWriter.flush();

    }
}