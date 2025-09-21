import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        char L = input[1].charAt(0);
        int count = 0;
        int num = 0;

        while (count < N) {
            num++;

            if (String.valueOf(num).indexOf(L) == -1) {
                count++;
            }
        }

        bufferedWriter.write(num + "\n");

        bufferedWriter.flush();

    }
}