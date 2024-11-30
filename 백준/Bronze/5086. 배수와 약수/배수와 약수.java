import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            String[] input = bufferedReader.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            if (A == 0 && B == 0) {
                break;
            }

            if (B % A == 0) {
                bufferedWriter.write("factor");
                bufferedWriter.newLine();
            } else if (A % B == 0) {
                bufferedWriter.write("multiple");
                bufferedWriter.newLine();
            } else {
                bufferedWriter.write("neither");
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.flush();

    }
}