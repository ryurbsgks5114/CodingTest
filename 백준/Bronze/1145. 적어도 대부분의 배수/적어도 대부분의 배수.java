import java.io.*;
import java.util.*;

public class Main {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;

            a = b;
            b = temp;
        }

        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int lcm(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int curLcm = lcm(nums[i], nums[j], nums[k]);

                    min = Math.min(min, curLcm);
                }
            }
        }

        bufferedWriter.write(String.valueOf(min));

        bufferedWriter.flush();

    }
}