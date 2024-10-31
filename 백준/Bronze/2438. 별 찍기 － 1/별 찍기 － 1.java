import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());

        Main main = new Main();

        for (int i = 0; i < N; i++) {
            bufferedWriter.write(main.printStars(i) + "\n");
        }

        bufferedWriter.flush();

    }

    private String printStars (int i) {
        return "*".repeat(i + 1);
    }
}