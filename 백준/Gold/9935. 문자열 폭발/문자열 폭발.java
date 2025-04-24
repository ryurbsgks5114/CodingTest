import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bufferedReader.readLine();
        String bomb = bufferedReader.readLine();

        int bombLen = bomb.length();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));

            if (stringBuilder.length() >= bombLen) {

                boolean isBoom = true;

                for (int j = 0; j < bombLen; j++) {
                    if (stringBuilder.charAt(stringBuilder.length() - bombLen + j) != bomb.charAt(j)) {
                        isBoom = false;

                        break;
                    }
                }

                if (isBoom) {
                    stringBuilder.delete(stringBuilder.length() - bombLen, stringBuilder.length());
                }
            }
        }

        if (stringBuilder.length() == 0) {
            bufferedWriter.write("FRULA\n");
        } else {
            bufferedWriter.write(stringBuilder.toString() + "\n");
        }

        bufferedWriter.flush();

    }
}