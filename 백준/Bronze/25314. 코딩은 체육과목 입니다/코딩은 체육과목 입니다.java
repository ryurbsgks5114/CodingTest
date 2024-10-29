import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int x = N / 4 - 1;

        Main main = new Main();
        String answer = main.getIntegerTypeName(x);

        System.out.println(answer);

    }

    private String getIntegerTypeName (int x) {

        String answer = "";

        for (int i = 0; i < x; i++) {
            answer = answer + "long ";
        }

        answer = answer + "long int";

        return answer;
    }
}