import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main = new Main();

        while (true) {

            String[] input = bufferedReader.readLine().split(" ");
            Integer A = Integer.valueOf(input[0]);
            Integer B = Integer.valueOf(input[1]);

            if (A.equals(0)) {
                break;
            }

            bufferedWriter.write(main.addTwoNumbers(A, B) + "\n");

        }

        bufferedWriter.flush();

    }

    private Integer addTwoNumbers (Integer A, Integer B) {
        return A + B;
    }
}