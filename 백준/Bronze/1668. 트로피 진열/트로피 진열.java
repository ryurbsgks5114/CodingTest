import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] trophies = new int[N];

        for (int i = 0; i < N; i++) {
            trophies[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int leftCount = 0;
        int maxHeight = 0;
        
        for (int i = 0; i < N; i++) {
            if (trophies[i] > maxHeight) {
                leftCount++;
                maxHeight = trophies[i];
            }
        }

        int rightCount = 0;
        maxHeight = 0;
        
        for (int i = N - 1; i >= 0; i--) {
            if (trophies[i] > maxHeight) {
                rightCount++;
                maxHeight = trophies[i];
            }
        }

        bufferedWriter.write(leftCount + "\n" + rightCount + "\n");

        bufferedWriter.flush();

    }
}