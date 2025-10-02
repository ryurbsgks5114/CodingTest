import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        int id;
        int count;
        int time;

        Student(int id, int count, int time) {
            this.id = id;
            this.count = count;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int total = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Map<Integer, Student> map = new HashMap<>();
        List<Student> frames = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            int id = Integer.parseInt(stringTokenizer.nextToken());

            if (map.containsKey(id)) {
                map.get(id).count++;
            } else {
                if (frames.size() < N) {
                    Student s = new Student(id, 1, i);
                    frames.add(s);
                    map.put(id, s);
                } else {
                    Student remove = Collections.min(frames, (a, b) -> {
                        if (a.count == b.count) {
                            return a.time - b.time;
                        }

                        return a.count - b.count;
                    });

                    frames.remove(remove);
                    map.remove(remove.id);

                    Student s = new Student(id, 1, i);
                    frames.add(s);
                    map.put(id, s);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (Student el: frames) {
            result.add(el.id);
        }
        
        Collections.sort(result);

        for (int el: result) {
            bufferedWriter.write(el + " ");
        }

        bufferedWriter.flush();

    }
}