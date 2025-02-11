import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Set<String> dancers = new HashSet<>();

        dancers.add("ChongChong");

        for (int i = 0; i < N; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            String A = input[0];
            String B = input[1];

            if (dancers.contains(A) || dancers.contains(B)) {
                dancers.add(A);
                dancers.add(B);
            }
        }
        
        bufferedWriter.write(String.valueOf(dancers.size()));

        bufferedWriter.flush();

    }
}