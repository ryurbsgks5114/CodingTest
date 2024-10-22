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
        Integer firstLine = main.addTwoNumbers(A, B);
        Integer secondLine = main.subtractTwoNumbers(A, B);
        Integer thirdLine = main.multiplyTwoNumbers(A, B);
        Integer fourthLine = main.divideTwoNumbersAndGetQuotient(A, B);
        Integer fifthLine = main.divideTwoNumbersAndGetRemainder(A, B);

        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
        System.out.println(fourthLine);
        System.out.println(fifthLine);

    }

    private Integer addTwoNumbers(Integer A, Integer B) {
        return A + B;
    }

    private Integer subtractTwoNumbers(Integer A, Integer B) {
        return A - B;
    }

    private Integer multiplyTwoNumbers(Integer A, Integer B) {
        return A * B;
    }

    private Integer divideTwoNumbersAndGetQuotient(Integer A, Integer B) {
        return A / B;
    }

    private Integer divideTwoNumbersAndGetRemainder(Integer A, Integer B) {
        return A % B;
    }
}