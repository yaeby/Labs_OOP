import Queue.ListQueue;
import Queue.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> stack = new ListQueue<Integer>();

        stack.enqueue(10);
        stack.enqueue(20);
        stack.enqueue(30);

        System.out.println(stack.dequeue());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}
