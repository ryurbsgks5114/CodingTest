import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        int length = S.length();
        int q = Integer.parseInt(bufferedReader.readLine());
        int[][] count = new int[26][length];

        count[S.charAt(0) - 'a'][0] = 1;

        for (int i = 1; i < length; i++) {

            int ch = S.charAt(i) - 'a';

            for (int j = 0; j < 26; j++) {
                count[j][i] = count[j][i - 1];
            }

            count[ch][i]++;
        }

        for (int i = 0; i < q; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            char alpha = stringTokenizer.nextToken().charAt(0);
            int l = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int idx = alpha - 'a';
            int result = count[idx][r] - (l > 0 ? count[idx][l - 1] : 0);
            
            bufferedWriter.write(result + "\n");
        }

        bufferedWriter.flush();

    }
}