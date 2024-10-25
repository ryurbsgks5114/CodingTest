import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        Integer H = Integer.valueOf(input[0]);
        Integer M = Integer.valueOf(input[1]);

        Main main = new Main();
        String answer = main.getAlarmTime(H, M);

        System.out.println(answer);

    }

    private String getAlarmTime(Integer H, Integer M) {

        String alarmTime = H + " " + (M - 45);

        if (M < 45) {

            H--;
            M = 60 - (45 - M);

            if (H < 0) {
                H = 23;
            }

            alarmTime = H + " " + M;

        }

        return alarmTime;
    }
}