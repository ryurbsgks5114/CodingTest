import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        double total = 0.0;
        double sum = 0.0;

        Main main = new Main();

        for (int i = 0; i < 20; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            double unit = Double.parseDouble(input[1]);
            String grade = input[2];

            if (grade.equals("P")) {
                continue;
            }

            double score = main.getScore(grade);

            sum = sum + unit * score;

            total = total + unit;

        }

        double average = sum / total;

        bufferedWriter.write(String.valueOf(average));

        bufferedWriter.flush();

    }

    public double getScore(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }
}