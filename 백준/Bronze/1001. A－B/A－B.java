import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArray = bufferedReader.readLine().split(" ");
        Integer A = Integer.valueOf(inputArray[0]);
        Integer B = Integer.valueOf(inputArray[1]);

        Main main = new Main();
        Integer answer = main.subtractTwoNumbers(A, B);

        System.out.println(answer);

    }

    private Integer subtractTwoNumbers(Integer A, Integer B) {
        return A - B;
    }
}