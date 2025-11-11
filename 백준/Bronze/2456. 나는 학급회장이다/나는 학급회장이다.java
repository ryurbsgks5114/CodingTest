import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] total = new int[4];  
        int[] count3 = new int[4];
        int[] count2 = new int[4];

        for (int i = 0; i < N; i++) {
            String[] parts = bufferedReader.readLine().split(" ");
            for (int j = 1; j <= 3; j++) {
                int score = Integer.parseInt(parts[j - 1]);
                total[j] += score;
                if (score == 3) count3[j]++;
                else if (score == 2) count2[j]++;
            }
        }

        int maxScore = Math.max(total[1], Math.max(total[2], total[3]));
        int candidate = 0;

        boolean[] top = new boolean[4];
        int countTop = 0;
        for (int i = 1; i <= 3; i++) {
            if (total[i] == maxScore) {
                top[i] = true;
                countTop++;
            }
        }

        if (countTop > 1) {
            int max3 = 0;
            for (int i = 1; i <= 3; i++) {
                if (top[i]) max3 = Math.max(max3, count3[i]);
            }

            int count3Top = 0;
            for (int i = 1; i <= 3; i++) {
                if (top[i] && count3[i] == max3) {
                    count3Top++;
                }
            }

            if (count3Top > 1) {
                int max2 = 0;
                for (int i = 1; i <= 3; i++) {
                    if (top[i] && count3[i] == max3)
                        max2 = Math.max(max2, count2[i]);
                }

                int count2Top = 0;
                for (int i = 1; i <= 3; i++) {
                    if (top[i] && count3[i] == max3 && count2[i] == max2)
                        count2Top++;
                }

                if (count2Top > 1) {
                    candidate = 0;
                } else {
                    for (int i = 1; i <= 3; i++) {
                        if (top[i] && count3[i] == max3 && count2[i] == max2)
                            candidate = i;
                    }
                }
            } else {
                for (int i = 1; i <= 3; i++) {
                    if (top[i] && count3[i] == max3)
                        candidate = i;
                }
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                if (top[i]) candidate = i;
            }
        }

        bufferedWriter.write(candidate + " " + maxScore);

        bufferedWriter.flush();

    }
}