import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {

            String string = bufferedReader.readLine();
            int n = Integer.parseInt(string);
            long square = (long) n * n;
            String newString = String.valueOf(square);

            if (newString.endsWith(string)) {
                bufferedWriter.write("YES\n");
            } else {
                bufferedWriter.write("NO\n");
            }
        }

        bufferedWriter.flush();

    }
}