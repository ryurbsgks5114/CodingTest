import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArray = bufferedReader.readLine().split(" ");
        double A = Integer.parseInt(inputArray[0]);
        double B = Integer.parseInt(inputArray[1]);

        Main main = new Main();
        double answer = main.divideTwoNumbers(A, B);

        System.out.println(answer);

    }

    private double divideTwoNumbers(double A, double B) {
        return A / B;
    }
}