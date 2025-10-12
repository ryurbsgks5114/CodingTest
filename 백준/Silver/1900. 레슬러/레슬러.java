import java.io.*;
import java.util.*;

public class Main {

    static class Player {
        int idx;
        int p, r;
        double ratio;

        Player(int idx, int p, int r) {
            this.idx = idx;
            this.p = p;
            this.r = r;
            this.ratio = (r == 1) ? Double.POSITIVE_INFINITY : (double) p / (r - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int p = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());

            players.add(new Player(i, p, r));
        }

        players.sort((a, b) -> {
            if (a.ratio == b.ratio) {
                return a.idx - b.idx;
            }

            return Double.compare(a.ratio, b.ratio);
        });

        for (Player el: players) {
            bufferedWriter.write(el.idx + "\n");
        }

        bufferedWriter.flush();

    }
}