import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        List<Member> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            String[] input = bufferedReader.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];

            members.add(new Member(age, name, i));

        }

        members.sort((a, b) -> {
            if (a.age == b.age) {
                return Integer.compare(a.order, b.order);
            }

            return Integer.compare(a.age, b.age);
        });

        for (Member member: members) {
            bufferedWriter.write(member.age + " " + member.name);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

    }

    public static class Member {

        int age;
        String name;
        int order;

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

    }
}