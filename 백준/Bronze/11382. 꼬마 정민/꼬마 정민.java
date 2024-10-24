import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        Long A = Long.valueOf(input[0]);
        Long B = Long.valueOf(input[1]);
        Long C = Long.valueOf(input[2]);

        Main main = new Main();
        Long answer = main.addThreeNumbers(A, B, C);

        System.out.println(answer);

    }

    private Long addThreeNumbers(Long A, Long B, Long C) {
        return A + B + C;
    }
}