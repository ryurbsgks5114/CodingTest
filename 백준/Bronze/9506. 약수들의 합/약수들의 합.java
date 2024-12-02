import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            int n = Integer.parseInt(bufferedReader.readLine());

            if (n == -1) {
                break;
            }

            ArrayList<Integer> arrayList = new ArrayList<>();

            int sum = 0;

            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    arrayList.add(i);
                    sum += i;
                }
            }

            if (sum == n) {

                bufferedWriter.write(n + " = ");

                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        bufferedWriter.write(" + ");
                    }
                    
                    bufferedWriter.write(String.valueOf(arrayList.get(i)));
                }

                bufferedWriter.newLine();

            } else {
                bufferedWriter.write(n + " is NOT perfect.");
                bufferedWriter.newLine();
            }

        }

        bufferedWriter.flush();

    }
}