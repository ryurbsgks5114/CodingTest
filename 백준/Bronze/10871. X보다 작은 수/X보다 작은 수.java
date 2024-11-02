import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        String[] A = bufferedReader.readLine().split(" ");
        Integer N = Integer.valueOf(input[0]);
        Integer X = Integer.valueOf(input[1]);

        Main main = new Main();
        bufferedWriter.write(main.findNumbersLessThanX(A, X));

        bufferedWriter.flush();

    }

    private String findNumbersLessThanX (String[] A, Integer X) {

        String answer = "";

        for (String el: A) {
            if (Integer.parseInt(el) < X) {
               answer = answer + el + " ";
            }
        }

        return answer;
    }
}