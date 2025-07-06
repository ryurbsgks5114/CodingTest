import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] height = new int[N];
        String[] tokens = bufferedReader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(tokens[i]);
        }

        int result = 0;

        for (int i = 0; i < N; i++) {

            int visible = 0;
            double maxSlope = Double.NEGATIVE_INFINITY;

            for (int j = i + 1; j < N; j++) {
                double slope = (double)(height[j] - height[i]) / (j - i);

                if (slope > maxSlope) {
                    maxSlope = slope;
                    visible++;
                }
            }

            double minSlope = Double.POSITIVE_INFINITY;

            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(height[j] - height[i]) / (j - i);

                if (slope < minSlope) {
                    minSlope = slope;
                    visible++;
                }
            }

            result = Math.max(result, visible);
        }

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}