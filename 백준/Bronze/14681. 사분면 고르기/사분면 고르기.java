import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.valueOf(bufferedReader.readLine());
        Integer y = Integer.valueOf(bufferedReader.readLine());

        Main main = new Main();
        Integer answer = main.getQuadrant(x, y);

        System.out.println(answer);

    }

    private Integer getQuadrant(Integer x, Integer y) {

        Integer quadrant = null;

        if (x > 0 && y > 0) {
            quadrant = 1;
        }

        if (x < 0 && y > 0) {
            quadrant = 2;
        }

        if (x < 0 && y < 0) {
            quadrant = 3;
        }

        if (x > 0 && y < 0) {
            quadrant = 4;
        }

        return quadrant;
    }
}