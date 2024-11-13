import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] piece = { 1, 1, 2, 2, 2, 8 };
        String[] findPiece = bufferedReader.readLine().split(" ");

        for (int i = 0; i < piece.length; i++) {

            int answer = piece[i] - Integer.parseInt(findPiece[i]);

            bufferedWriter.write(answer + " ");

        }

        bufferedWriter.flush();

    }
}