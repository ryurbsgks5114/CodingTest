import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        String color1 = bufferedReader.readLine();
        String color2 = bufferedReader.readLine();
        String color3 = bufferedReader.readLine();

        int first = map.get(color1);
        int second = map.get(color2);
        int multiplier = (int) Math.pow(10, map.get(color3));
        long result = (first * 10L + second) * multiplier;

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}