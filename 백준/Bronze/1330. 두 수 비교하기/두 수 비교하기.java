import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        Integer A = Integer.valueOf(input[0]);
        Integer B = Integer.valueOf(input[1]);

        Main main = new Main();
        String answer = main.compareAndGetOperator(A, B);

        System.out.println(answer);

    }

    private String compareAndGetOperator(Integer A, Integer B) {

        String operator = "";

        if (A > B) {
            operator = ">";
        }

        if (A < B) {
            operator = "<";
        }

        if (A.equals(B)) {
            operator = "==";
        }

        return operator;
    }
}