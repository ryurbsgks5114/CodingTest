import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] boxes = new int[N];
        int[] books = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            books[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int boxIdx = 0;
        int bookIdx = 0;
        int waste = 0;

        while (bookIdx < M && boxIdx < N) {
            if (boxes[boxIdx] >= books[bookIdx]) {
                boxes[boxIdx] -= books[bookIdx];
                bookIdx++;
            } else {
                waste += boxes[boxIdx];
                boxIdx++;
            }
        }

        while (boxIdx < N) {
            waste += boxes[boxIdx];
            boxIdx++;
        }

        bufferedWriter.write(waste + "\n");

        bufferedWriter.flush();

    }
}