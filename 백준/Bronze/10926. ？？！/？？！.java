import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = bufferedReader.readLine();

        Main main = new Main();
        String answer = main.checkDuplicateUsername(inputString);

        System.out.println(answer);

    }

    private String checkDuplicateUsername(String username) {
        return username + "??!";
    }
}