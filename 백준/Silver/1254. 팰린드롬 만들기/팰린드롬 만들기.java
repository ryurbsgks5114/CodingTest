import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();
        int n = s.length();
        int longestPalindromeSuffix = 0;

        for (int i = 0; i < n; i++) {
            if (isPalindrome(s, i, n - 1)) {
                longestPalindromeSuffix = n - i;

                break;
            }
        }

        int result = n + (n - longestPalindromeSuffix);

        bufferedWriter.write(result + "\n");

        bufferedWriter.flush();

    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }
        
        return true;
    }
}