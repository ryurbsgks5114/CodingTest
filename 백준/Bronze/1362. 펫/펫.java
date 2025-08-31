import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        int scenario = 1;

        while (!(line = bufferedReader.readLine()).equals("0 0")) {

            String[] first = line.split(" ");
            int o = Integer.parseInt(first[0]);
            int w = Integer.parseInt(first[1]);
            boolean dead = false;

            while (!(line = bufferedReader.readLine()).equals("# 0")) {

                String[] action = line.split(" ");
                char type = action[0].charAt(0);
                int n = Integer.parseInt(action[1]);

                if (dead) {
                    continue;
                }

                if (type == 'F') {
                    w += n;
                } else if (type == 'E') {
                    w -= n;
                }

                if (w <= 0) {
                    dead = true;
                }
            }

            String result;

            if (dead) {
                result = "RIP";
            } else if (w > o / 2 && w < o * 2) {
                result = ":-)";
            } else {
                result = ":-(";
            }

            bufferedWriter.write(scenario + " " + result + "\n");

            scenario++;
        }

        bufferedWriter.flush();

    }
}