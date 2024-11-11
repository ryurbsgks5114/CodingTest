import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().trim().split(" ");

        if (input[0].isEmpty()) {
            bufferedWriter.write("0");
        } else {
            bufferedWriter.write(String.valueOf(input.length));
        }
        
        bufferedWriter.flush();

    }
}