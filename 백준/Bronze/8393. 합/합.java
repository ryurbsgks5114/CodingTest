import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(bufferedReader.readLine());

        Main main = new Main();
        Integer answer = main.sumUpTo(n);

        System.out.println(answer);

    }

    private Integer sumUpTo (Integer n) {

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            answer = answer + i;

        }

        return answer;
    }
}