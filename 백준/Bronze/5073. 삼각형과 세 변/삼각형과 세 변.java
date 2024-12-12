import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            String[] input = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int[] sides = { a, b, c };

            Arrays.sort(sides);
            a = sides[0];
            b = sides[1];
            c = sides[2];

            if (a + b <= c) {
                bufferedWriter.write("Invalid");
                bufferedWriter.newLine();
            } else if (a == b && b == c) {
                bufferedWriter.write("Equilateral");
                bufferedWriter.newLine();
            } else if (a == b || b == c) {
                bufferedWriter.write("Isosceles");
                bufferedWriter.newLine();
            } else {
                bufferedWriter.write("Scalene");
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.flush();

    }
}