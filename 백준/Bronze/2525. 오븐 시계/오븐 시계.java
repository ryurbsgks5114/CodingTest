import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstInput = bufferedReader.readLine().split(" ");
        Integer secondInput = Integer.valueOf(bufferedReader.readLine());
        Integer A = Integer.valueOf(firstInput[0]);
        Integer B = Integer.valueOf(firstInput[1]);

        Main main = new Main();
        String answer = main.getFinishTime(A, B, secondInput);

        System.out.println(answer);

    }

    private String getFinishTime(Integer A, Integer B, Integer secondInput) {

        Integer minute = B + secondInput;
        String finishTime = A + " " + minute;

        while (minute >= 60) {

            A++;
            minute = minute - 60;

            if (A >= 24) {
                A = 0;
            }

            finishTime = A + " " + minute;

        }

        return finishTime;
    }
}