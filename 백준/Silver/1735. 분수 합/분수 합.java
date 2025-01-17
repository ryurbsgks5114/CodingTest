import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        String[] newInput = bufferedReader.readLine().split(" ");
        int inputA = Integer.parseInt(input[0]);
        int inputB = Integer.parseInt(input[1]);
        int newInputA = Integer.parseInt(newInput[0]);
        int newInputB = Integer.parseInt(newInput[1]);

        int lcm = LCM(inputB, newInputB);
        int sum = (inputA * (lcm / inputB)) + (newInputA * (lcm / newInputB));
        int gcd = GCD(sum, lcm);
        int numerator = sum / gcd;
        int denominator  = lcm / gcd;

        bufferedWriter.write(numerator + " " + denominator);

        bufferedWriter.flush();

    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
}