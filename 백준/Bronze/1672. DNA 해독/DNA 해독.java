import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String dna = bufferedReader.readLine();
        char[][] table = {
                {'A', 'C', 'A', 'G'},
                {'C', 'G', 'T', 'A'},
                {'A', 'T', 'C', 'G'},
                {'G', 'A', 'G', 'T'}
        };

        int[] index = new int[128];
        index['A'] = 0;
        index['G'] = 1;
        index['C'] = 2;
        index['T'] = 3;

        char result = dna.charAt(N - 1);

        for (int i = N - 2; i >= 0; i--) {
            char current = dna.charAt(i);

            result = table[index[current]][index[result]];
        }

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }
}