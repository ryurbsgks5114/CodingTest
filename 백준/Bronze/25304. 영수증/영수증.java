import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer X = Integer.valueOf(bufferedReader.readLine());
        int N = Integer.parseInt(bufferedReader.readLine());

        int amount = 0;

        for (int i = 0; i < N; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            Integer a = Integer.valueOf(input[0]);
            Integer b = Integer.valueOf(input[1]);

            amount = amount + a * b;

        }

        Main main = new Main();
        String answer = main.checkAmount(X, amount);

        System.out.println(answer);

    }

    private String checkAmount (Integer X, Integer amount) {

        String answer = "No";

        if (X.equals(amount)) {
            answer = "Yes";
        }

        return answer;
    }
}