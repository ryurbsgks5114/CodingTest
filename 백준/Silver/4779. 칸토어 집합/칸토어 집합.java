import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while ((input = bufferedReader.readLine()) != null) {

            int N = Integer.parseInt(input);

            bufferedWriter.write(cantor(N) + "\n");

        }

        bufferedWriter.flush();

    }

    public static String cantor(int N) {
        if (N == 0) {
            return "-";
        }

        String prev = cantor(N - 1);
        String space = " ".repeat(prev.length());

        return prev + space + prev;
    }
}