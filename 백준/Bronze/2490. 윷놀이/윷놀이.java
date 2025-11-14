import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {

            String[] arr = bufferedReader.readLine().split(" ");
            int zeroCount = 0;

            for (String s: arr) {
                if (s.equals("0")) {
                    zeroCount++;
                }
            }

            char result;
            
            switch (zeroCount) {
                case 1: result = 'A'; break;
                case 2: result = 'B'; break;
                case 3: result = 'C'; break;
                case 4: result = 'D'; break;
                case 0: result = 'E'; break;
                default: result = '?';
            }

            bufferedWriter.write(result + "\n");
        }

        bufferedWriter.flush();

    }
}