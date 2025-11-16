import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] time = bufferedReader.readLine().split(" ");
        int A = Integer.parseInt(time[0]);
        int B = Integer.parseInt(time[1]);
        int C = Integer.parseInt(time[2]);
        int D = Integer.parseInt(bufferedReader.readLine());
        int total = A * 3600 + B * 60 + C + D;
        int hour = (total / 3600) % 24;
        int minute = (total % 3600) / 60;
        int second = total % 60;

        bufferedWriter.write(hour + " " + minute + " " + second);

        bufferedWriter.flush();

    }
}