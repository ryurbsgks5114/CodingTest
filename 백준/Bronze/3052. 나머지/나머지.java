import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCount = 10;
        int staticNumber = 42;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < inputCount; i++) {

            int number = Integer.parseInt(bufferedReader.readLine());

            hashSet.add(number % staticNumber);

        }

        bufferedWriter.write(String.valueOf(hashSet.size()));

        bufferedWriter.flush();

    }
}