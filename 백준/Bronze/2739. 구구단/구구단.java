import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer input = Integer.valueOf(bufferedReader.readLine());

        Main main = new Main();
        main.gugudan(input);

    }

    private void gugudan (Integer input) {

        for (int i = 1; i < 10; i++) {

            String answer = input + " * " + i + " = " + (input * i);
            System.out.println(answer);

        }

    }
}