import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = "         ,r'\"7\n" +
                "r`-_   ,'  ,/\n" +
                " \\. \". L_r'\n" +
                "   `~\\/\n" +
                "      |\n" +
                "      |";

        bufferedWriter.write(answer);

        bufferedWriter.flush();

    }
}