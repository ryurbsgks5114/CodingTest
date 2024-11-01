import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        Main main = new Main();

        while ((input = bufferedReader.readLine()) != null) {

            String[] inputArray = input.split(" ");
            Integer A = Integer.valueOf(inputArray[0]);
            Integer B = Integer.valueOf(inputArray[1]);

            bufferedWriter.write(main.addTwoNumbers(A, B) + "\n");

        }

        bufferedWriter.flush();

    }

    private Integer addTwoNumbers (Integer A, Integer B) {
        return A + B;
    }
}