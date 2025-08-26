import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while (!(line = bufferedReader.readLine()).equals("#")) {
            int count = 0;

            for (char c: line.toCharArray()) {
                switch (Character.toLowerCase(c)) {
                    case 'a': case 'e': case 'i': case 'o': case 'u':
                        count++;
                        
                        break;
                }
            }

            bufferedWriter.write(count + "\n");
        }

        bufferedWriter.flush();

    }
}