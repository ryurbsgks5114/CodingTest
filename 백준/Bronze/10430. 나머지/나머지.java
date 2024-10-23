import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        Integer A = Integer.valueOf(input[0]);
        Integer B = Integer.valueOf(input[1]);
        Integer C = Integer.valueOf(input[2]);

        Main main = new Main();
        Integer firstAnswer = main.calculateFirstLine(A, B, C);
        Integer secondAnswer = main.calculateSecondLine(A, B, C);
        Integer ThirdAnswer = main.calculateThirdLine(A, B, C);
        Integer FourthAnswer = main.calculateFourthLine(A, B, C);

        System.out.println(firstAnswer);
        System.out.println(secondAnswer);
        System.out.println(ThirdAnswer);
        System.out.println(FourthAnswer);

    }

    private Integer calculateFirstLine(Integer A, Integer B, Integer C) {
        return (A + B) % C;
    }

    private Integer calculateSecondLine(Integer A, Integer B, Integer C) {
        return ((A % C) + (B % C)) % C;
    }

    private Integer calculateThirdLine(Integer A, Integer B, Integer C) {
        return (A * B) % C;
    }

    private Integer calculateFourthLine(Integer A, Integer B, Integer C) {
        return ((A % C) * (B % C)) % C;
    }
}