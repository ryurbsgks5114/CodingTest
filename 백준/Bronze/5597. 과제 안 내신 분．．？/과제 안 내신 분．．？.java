import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] student = new Integer[30];

        for (int i = 0; i < 28; i++) {
            student[Integer.parseInt(bufferedReader.readLine()) - 1] = 1;
        }

        for (int i = 0; i < 30; i++) {
            if (student[i] == null) {
                bufferedWriter.write((i + 1) + "\n");
            }
        }

        bufferedWriter.flush();

    }
}