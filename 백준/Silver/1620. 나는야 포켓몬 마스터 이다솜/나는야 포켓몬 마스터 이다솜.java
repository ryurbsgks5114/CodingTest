import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<Integer, String> numberToName = new HashMap<>();
        Map<String, Integer> nameToNumber = new HashMap<>();

        for (int i = 1; i <= N; i++) {

            String pokemonName = bufferedReader.readLine();

            numberToName.put(i, pokemonName);
            nameToNumber.put(pokemonName, i);

        }

        for (int i = 0; i < M; i++) {

            String query = bufferedReader.readLine();

            if (Character.isDigit(query.charAt(0))) {

                int number = Integer.parseInt(query);

                bufferedWriter.write(numberToName.get(number));

            } else {
                bufferedWriter.write(String.valueOf(nameToNumber.get(query)));
            }

            bufferedWriter.newLine();

        }

        bufferedWriter.flush();

    }
}