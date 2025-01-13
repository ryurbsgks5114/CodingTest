import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int sizeA = Integer.parseInt(input[0]);
        int sizeB = Integer.parseInt(input[1]);

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        String[] A = bufferedReader.readLine().split(" ");

        for (String el: A) {
            setA.add(Integer.parseInt(el));
        }

        String[] B = bufferedReader.readLine().split(" ");

        for (String el: B) {
            setB.add(Integer.parseInt(el));
        }

        Set<Integer> difference = new HashSet<>(setA);
        difference.addAll(setB);
        difference.removeAll(intersection(setA, setB));

        bufferedWriter.write(String.valueOf(difference.size()));

        bufferedWriter.flush();

    }

    private static Set<Integer> intersection(Set<Integer> setA, Set<Integer> setB) {

        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        return intersection;
    }
}