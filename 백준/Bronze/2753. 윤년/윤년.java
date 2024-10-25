import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer input = Integer.valueOf(bufferedReader.readLine());

        Main main = new Main();
        Integer answer = main.checkLeapYear(input);

        System.out.println(answer);

    }

    private Integer checkLeapYear(Integer input) {

        if ((input % 4 == 0 && input % 100 != 0) || input % 400 == 0) {
            return 1;
        }

        return 0;
    }
}