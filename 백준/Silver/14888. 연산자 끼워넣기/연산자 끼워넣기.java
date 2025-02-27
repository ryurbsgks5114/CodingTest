import java.io.*;

public class Main {

    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];

        String[] numInput = bufferedReader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numInput[i]);
        }

        String[] opInput = bufferedReader.readLine().split(" ");

        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(opInput[i]);
        }

        backtrack(1, numbers[0]);

        bufferedWriter.write(maxResult + "\n" + minResult + "\n");

        bufferedWriter.flush();

    }

    public static void backtrack(int index, int currentResult) {
        if (index == N) {
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int nextResult = calculate(currentResult, numbers[index], i);

                backtrack(index + 1, nextResult);

                operators[i]++;
            }
        }
    }

    public static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            case 3: return a / b;
            default: return 0;
        }
    }
}