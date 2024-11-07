import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();
        int i = Integer.parseInt(bufferedReader.readLine());

        bufferedWriter.write(S.charAt(i - 1));

        bufferedWriter.flush();

    }
}