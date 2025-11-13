import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(input[i]);
            
            sum += num * num;
        }

        int result = sum % 10;
        
        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}