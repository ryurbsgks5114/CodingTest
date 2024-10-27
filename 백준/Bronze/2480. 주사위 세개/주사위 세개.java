import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        Integer firstDice = Integer.valueOf(input[0]);
        Integer secondDice = Integer.valueOf(input[1]);
        Integer thirdDice = Integer.valueOf(input[2]);

        Main main = new Main();
        Integer answer = main.calculatePrizeMoney(firstDice, secondDice, thirdDice);

        System.out.println(answer);

    }

    private Integer calculatePrizeMoney(Integer firstDice, Integer secondDice, Integer thirdDice) {

        if (firstDice.equals(secondDice) && firstDice.equals(thirdDice)) {
            return 10000 + firstDice * 1000;
        } else if (firstDice.equals(secondDice) || firstDice.equals(thirdDice) || secondDice.equals(thirdDice)) {

            int sameDice = firstDice.equals(secondDice) ? firstDice : thirdDice;

            return 1000 + sameDice * 100;
        } else {

            int maxDice = Math.max(firstDice, Math.max(secondDice, thirdDice));

            return maxDice * 100;
        }

    }
}