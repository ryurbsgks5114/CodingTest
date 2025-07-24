import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] files = new String[n];

        for (int i = 0; i < n; i++) {
            files[i] = bufferedReader.readLine();
        }

        StringBuilder stringBuilder = new StringBuilder();
        int length = files[0].length();

        for (int i = 0; i < length; i++) {

            char current = files[0].charAt(i);
            boolean allSame = true;

            for (int j = 1; j < n; j++) {
                if (files[j].charAt(i) != current) {
                    allSame = false;

                    break;
                }
            }

            if (allSame) {
                stringBuilder.append(current);
            } else {
                stringBuilder.append('?');
            }
        }

        bufferedWriter.write(stringBuilder + "\n");

        bufferedWriter.flush();

    }
}