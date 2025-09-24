import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        long next;
        
        if (arr[1] - arr[0] == arr[2] - arr[1]) {
            int diff = arr[1] - arr[0];
            
            next = (long) arr[N - 1] + diff;
        } else {
            int ratio = arr[1] / arr[0];
            
            next = (long) arr[N - 1] * ratio;
        }

        bufferedWriter.write(String.valueOf(next));

        bufferedWriter.flush();

    }
}