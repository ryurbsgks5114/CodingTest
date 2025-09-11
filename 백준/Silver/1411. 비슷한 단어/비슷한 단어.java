import java.io.*;
import java.util.*;

public class Main {

    static boolean similar(String a, String b) {

        int[] mapA = new int[26];
        int[] mapB = new int[26];

        Arrays.fill(mapA, -1);
        Arrays.fill(mapB, -1);

        for (int i = 0; i < a.length(); i++) {

            int ca = a.charAt(i) - 'a';
            int cb = b.charAt(i) - 'a';

            if (mapA[ca] == -1) {
                mapA[ca] = cb;
            } else if (mapA[ca] != cb) {
                return false;
            }

            if (mapB[cb] == -1) {
                mapB[cb] = ca;
            } else if (mapB[cb] != ca) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[N];
        
        for (int i = 0; i < N; i++) {
            words[i] = bufferedReader.readLine().trim();
        }

        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (similar(words[i], words[j])) {
                    count++;
                }
            }
        }

        bufferedWriter.write(count + "\n");

        bufferedWriter.flush();

    }
}