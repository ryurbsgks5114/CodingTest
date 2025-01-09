import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        Set<String> people = new HashSet<>();

        for (int i = 0; i < n; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            String name = input[0];
            String action = input[1];

            if (action.equals("enter")) {
                people.add(name);
            } else if (action.equals("leave")) {
                people.remove(name);
            }
        }

        List<String> sortedList = new ArrayList<>(people);
        sortedList.sort(Collections.reverseOrder());

        for (String name: sortedList) {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}