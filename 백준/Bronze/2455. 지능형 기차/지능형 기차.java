import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int current = 0;
        int maxPeople = 0;

        for (int i = 0; i < 4; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int out = Integer.parseInt(input[0]);
            int in = Integer.parseInt(input[1]);

            current = current - out + in;

            if (current > maxPeople) {
                maxPeople = current;
            }
        }

        bufferedWriter.write(String.valueOf(maxPeople));

        bufferedWriter.flush();

    }
}