import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken()) % 10;
            int b = Integer.parseInt(stringTokenizer.nextToken());

            if (a == 0) {
                bufferedWriter.write("10\n");

                continue;
            }

            List<Integer> pattern = new ArrayList<>();
            int current = a;

            while (!pattern.contains(current)) {
                pattern.add(current);
                current = (current * a) % 10;
            }

            int index = (b - 1) % pattern.size();

            bufferedWriter.write(pattern.get(index) + "\n");
        }

        bufferedWriter.flush();

    }
}