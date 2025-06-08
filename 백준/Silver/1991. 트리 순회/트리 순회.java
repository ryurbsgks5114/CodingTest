import java.io.*;
import java.util.*;

public class Main {

    static Node[] tree = new Node[26];
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    static class Node {

        char left, right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = bufferedReader.readLine().split(" ");
            char parent = tokens[0].charAt(0);
            char left = tokens[1].charAt(0);
            char right = tokens[2].charAt(0);

            tree[parent - 'A'] = new Node(left, right);
        }

        preorder('A');
        inorder('A');
        postorder('A');

        bufferedWriter.write(pre.toString() + "\n");
        bufferedWriter.write(in.toString() + "\n");
        bufferedWriter.write(post.toString() + "\n");

        bufferedWriter.flush();

    }

    static void preorder(char current) {
        if (current == '.') {
            return;
        }

        pre.append(current);
        preorder(tree[current - 'A'].left);
        preorder(tree[current - 'A'].right);
    }

    static void inorder(char current) {
        if (current == '.') {
            return;
        }

        inorder(tree[current - 'A'].left);
        in.append(current);
        inorder(tree[current - 'A'].right);
    }

    static void postorder(char current) {
        if (current == '.') {
            return;
        }

        postorder(tree[current - 'A'].left);
        postorder(tree[current - 'A'].right);
        post.append(current);
    }
}