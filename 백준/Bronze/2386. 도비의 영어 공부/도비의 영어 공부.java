import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = bufferedReader.readLine();

            if (line.equals("#")) {
                break;
            }

            char target = line.charAt(0);
            String sentence = line.substring(2);
            target = Character.toLowerCase(target);

            int count = 0;

            for (char el: sentence.toCharArray()) {
                if (Character.toLowerCase(el) == target) {
                    count++;
                }
            }

            bufferedWriter.write(target + " " + count + "\n");
        }

        bufferedWriter.flush();

    }
}