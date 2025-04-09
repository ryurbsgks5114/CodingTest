import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());

        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N - 1] - houses[0];
        int answer = 0;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (canPlace(houses, C, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bufferedWriter.write(answer + "\n");

        bufferedWriter.flush();

    }

    private static boolean canPlace(int[] houses, int C, int dist) {

        int count = 1;
        int lastPos = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastPos >= dist) {
                count++;
                lastPos = houses[i];
            }
        }

        return count >= C;
    }
}