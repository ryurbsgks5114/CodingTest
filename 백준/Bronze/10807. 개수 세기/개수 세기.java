import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.valueOf(bufferedReader.readLine());
        String[] array = bufferedReader.readLine().split(" ");
        Integer v = Integer.valueOf(bufferedReader.readLine());

        Main main = new Main();

        bufferedWriter.write(String.valueOf(main.getVCount(array, v)));

        bufferedWriter.flush();

    }

    private Integer getVCount (String[] array, Integer v) {

        Integer count = 0;

        for (String el: array) {
            if (Integer.valueOf(el).equals(v)) {
                count++;
            }
        }

        return count;
    }
}