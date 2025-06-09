import java.io.*;
import java.util.*;

public class Main {

    static int[] postorder;
    static int[] index;
    static BufferedWriter bufferedWriter;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] inorder = new int[n];
        postorder = new int[n];
        index = new int[n + 1];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(stringTokenizer.nextToken());
            index[inorder[i]] = i;
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        solve(0, n - 1, 0, n - 1);

        bufferedWriter.flush();

    }

    static void solve(int inStart, int inEnd, int postStart, int postEnd) throws IOException {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postorder[postEnd];

        bufferedWriter.write(root + " ");

        int rootIndex = index[root];
        int leftSize = rootIndex - inStart;

        solve(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);

        solve(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}