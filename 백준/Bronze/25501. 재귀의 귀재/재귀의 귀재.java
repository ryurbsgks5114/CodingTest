import java.io.*;

public class Main {

    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {

            String S = bufferedReader.readLine();

            count = 0;

            int result = isPalindrome(S);

            bufferedWriter.write(result + " " + count + "\n");
            
        }

        bufferedWriter.flush();

    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static int recursion(String s, int l, int r) {

        count++;

        if (l >= r) {
            return 1;
        }

        if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }

        return recursion(s, l + 1, r - 1);
    }
}