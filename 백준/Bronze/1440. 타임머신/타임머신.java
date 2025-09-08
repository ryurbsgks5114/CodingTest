import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String time = bufferedReader.readLine();
        String[] parts = time.split(":");

        int[] nums = new int[3];

        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        int count = 0;
        int[] idx = { 0, 1, 2 };

        do {
            int h = nums[idx[0]];
            int m = nums[idx[1]];
            int s = nums[idx[2]];

            if (isHour(h) && isMinuteOrSecond(m) && isMinuteOrSecond(s)) {
                count++;
            }
        } while (nextPermutation(idx));

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }

    static boolean isHour(int h) {
        return 1 <= h && h <= 12;
    }

    static boolean isMinuteOrSecond(int x) {
        return 0 <= x && x <= 59;
    }

    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;

        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        swap(arr, i - 1, j);

        int k = arr.length - 1;

        while (i < k) {
            swap(arr, i++, k--);
        }

        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];

        arr[i] = arr[j];
        arr[j] = tmp;
    }
}