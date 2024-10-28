import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        Main main = new Main();

        for (int i = 0; i < T; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            Integer A = Integer.valueOf(input[0]);
            Integer B = Integer.valueOf(input[1]);

            Integer answer = main.addTwoNumbers(A, B);
            System.out.println(answer);

        }

    }

    private Integer addTwoNumbers (Integer A, Integer B) {
        return A + B;
    }
}