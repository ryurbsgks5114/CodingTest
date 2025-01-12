import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> unheard = new HashSet<>();

        for (int i = 0; i < N; i++) {
            unheard.add(bufferedReader.readLine());
        }

        List<String> unheardAndUnseen = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String name = bufferedReader.readLine();

            if (unheard.contains(name)) {
                unheardAndUnseen.add(name);
            }
        }

        Collections.sort(unheardAndUnseen);

        bufferedWriter.write(String.valueOf(unheardAndUnseen.size()));
        bufferedWriter.newLine();

        for (String name: unheardAndUnseen) {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }
}