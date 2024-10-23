import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Integer input = Integer.valueOf(bufferedReader.readLine());

        Main main = new Main();
        Integer answer = main.convertYear(input);

        System.out.println(answer);

    }

    private Integer convertYear(Integer year) {
        return year - 543;
    }
}