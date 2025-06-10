import java.io.*;
import java.util.*;

public class Main {

    static int[] preorder = new int[10000];
    static int idx = 0;
    static BufferedWriter bufferedWriter;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            preorder[idx++] = Integer.parseInt(line);
        }

        postorder(0, idx - 1);

        bufferedWriter.flush();

    }

    static void postorder(int start, int end) throws IOException {
        if (start > end) {
            return;
        }

        int root = preorder[start];
        int rightStart = end + 1;

        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > root) {
                rightStart = i;

                break;
            }
        }

        postorder(start + 1, rightStart - 1);
        postorder(rightStart, end);

        bufferedWriter.write(root + "\n");

    }
}