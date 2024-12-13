import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int[] sides = new int[3];
        sides[0] = a;
        sides[1] = b;
        sides[2] = c;
        Arrays.sort(sides);

        while (sides[2] >= sides[0] + sides[1]) {
            sides[2]--;
        }

        int answer = sides[0] + sides[1] + sides[2];

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();

    }
}