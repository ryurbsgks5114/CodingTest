import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);

        int count = 0;
        int lastEndTime = 0;

        for (Meeting el: meetings) {
            if (el.start >= lastEndTime) {
                count++;
                lastEndTime = el.end;
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();

    }

    static class Meeting implements Comparable<Meeting> {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            
            return this.end - o.end;
        }
    }
}