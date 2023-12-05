import Queue.ListQueue;
import Queue.Queue;
import Queue.ArrayQueue;
import Queue.Queue;
import Stack.LinkedListStack;
import Stack.ListStack;
import Stack.LinkedListStack;
import Stack.ArrayStack;
import Stack.Stack;
import Stack.ListStack;

public class Main {
    public static void main(String[] args) {
        //Testes
        Queue<Integer> queue = new ListQueue<Integer>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.size() + "\n");

        Queue<String> queue2 = new ArrayQueue<String>(3);
        queue2.enqueue("String one");
        queue2.enqueue("String two");
        queue2.enqueue("String tree");
        System.out.println(queue2.dequeue());
        System.out.println(queue2.peek());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue() + "\n");
        //System.out.println(queue2.dequeue());

        Stack<Integer> stack = new ListStack<Integer>();
        stack.push(777);
        stack.push(888);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop()+"\n");

        Stack<String> stack2 = new LinkedListStack<String>();
        stack2.push("El 1");
        stack2.push("EL 2");
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());
        System.out.println(stack2.pop());
    }
}
