import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());
        Pattern pattern = Pattern.compile("^(100+1+|01)+$");

        while (T-- > 0) {

            String signal = bufferedReader.readLine();
            Matcher matcher = pattern.matcher(signal);

            if (matcher.matches()) {
                bufferedWriter.write("YES\n");
            } else {
                bufferedWriter.write("NO\n");
            }
        }

        bufferedWriter.flush();

    }
}