import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] input = bufferedReader.readLine().split(" ");

        Main main = new Main();

        int count = 0;

        for (String number : input) {
            
            int num = Integer.parseInt(number);
            
            if (main.isPrime(num)) {
                count++;
            }
            
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}