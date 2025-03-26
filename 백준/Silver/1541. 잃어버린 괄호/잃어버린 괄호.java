import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] groups = bufferedReader.readLine().split("-");

        int result = sum(groups[0]);

        for (int i = 1; i < groups.length; i++) {
            result -= sum(groups[i]);
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();

    }

    private static int sum(String s) {

        String[] numbers = s.split("\\+");

        int total = 0;

        for (String el: numbers) {
            total += Integer.parseInt(el);
        }

        return total;
    }
}