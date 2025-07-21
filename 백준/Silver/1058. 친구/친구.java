import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        char[][] relation = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < N; j++) {
                relation[i][j] = line.charAt(j);
            }
        }

        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            boolean[] isFriend = new boolean[N];

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                if (relation[i][j] == 'Y') {
                    isFriend[j] = true;
                } else {
                    for (int k = 0; k < N; k++) {
                        if (relation[i][k] == 'Y' && relation[k][j] == 'Y') {
                            isFriend[j] = true;

                            break;
                        }
                    }
                }
            }

            int count = 0;

            for (boolean el: isFriend) {
                if (el) {
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        bufferedWriter.write(maxCount + "\n");

        bufferedWriter.flush();

    }
}