import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int angle1 = Integer.parseInt(bufferedReader.readLine());
        int angle2 = Integer.parseInt(bufferedReader.readLine());
        int angle3 = Integer.parseInt(bufferedReader.readLine());

        int sum = angle1 + angle2 + angle3;

        if (sum != 180) {
            bufferedWriter.write("Error");
        } else if (angle1 == 60 && angle2 == 60 && angle3 == 60) {
            bufferedWriter.write("Equilateral");
        } else if (angle1 == angle2 || angle2 == angle3 || angle1 == angle3) {
            bufferedWriter.write("Isosceles");
        } else {
            bufferedWriter.write("Scalene");
        }

        bufferedWriter.flush();

    }
}