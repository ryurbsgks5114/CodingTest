import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        String A = input[0];
        String B = input[1];
        int minDiff = Integer.MAX_VALUE;
        int aLen = A.length();
        int bLen = B.length();

        for (int i = 0; i <= bLen - aLen; i++) {

            String sub = B.substring(i, i + aLen);
            int diff = 0;
            
            for (int j = 0; j < aLen; j++) {
                if (A.charAt(j) != sub.charAt(j)) {
                    diff++;
                }
            }

            minDiff = Math.min(minDiff, diff);
        }

        bufferedWriter.write(String.valueOf(minDiff));

        bufferedWriter.flush();

    }
}