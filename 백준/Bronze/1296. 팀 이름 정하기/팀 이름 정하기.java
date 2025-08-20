import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String yeondoo = bufferedReader.readLine();
        int n = Integer.parseInt(bufferedReader.readLine());

        String answer = "";
        int bestScore = -1;

        for (int i = 0; i < n; i++) {

            String team = bufferedReader.readLine();
            int score = getScore(yeondoo, team);

            if (score > bestScore) {
                bestScore = score;
                answer = team;
            } else if (score == bestScore && team.compareTo(answer) < 0) {
                answer = team;
            }
        }

        bufferedWriter.write(answer + "\n");

        bufferedWriter.flush();

    }

    private static int getScore(String yeondoo, String team) {

        String combined = yeondoo + team;
        int L = 0, O = 0, V = 0, E = 0;

        for (char c: combined.toCharArray()) {
            if (c == 'L') {
                L++;
            } else if (c == 'O') {
                O++;
            } else if (c == 'V') {
                V++;
            } else if (c == 'E') {
                E++;
            }
        }

        int score = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;

        return score;
    }
}