import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] input = bufferedReader.readLine().split(" ");

        Queue<Integer> queue = new LinkedList<>();

        for (String el: input) {
            queue.offer(Integer.parseInt(el));
        }

        Stack<Integer> stack = new Stack<>();

        int currentNumber = 1;

        while (!queue.isEmpty() || !stack.isEmpty()) {
            if (!queue.isEmpty() && queue.peek() == currentNumber) {
                queue.poll();
                currentNumber++;
            } else if (!stack.isEmpty() && stack.peek() == currentNumber) {
                stack.pop();
                currentNumber++;
            } else if (!queue.isEmpty()) {
                stack.push(queue.poll());
            } else {
                bufferedWriter.write("Sad");

                bufferedWriter.flush();

                return;
            }
        }

        bufferedWriter.write("Nice");

        bufferedWriter.flush();

    }
}