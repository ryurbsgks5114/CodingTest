import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                count++;
            }
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }

    private static boolean isHansu(int num) {
        if (num < 100) {
            return true;
        }

        if (num == 1000) {
            return false;
        }

        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;

        return (a - b) == (b - c);
    }
}