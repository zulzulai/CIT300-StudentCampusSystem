package structures;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {

    private Queue<String> queue = new LinkedList<>();

    public void enqueue(String req) {
        queue.add(req);
    }

    public String dequeue() {
        return queue.poll();
    }

    public String peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue empty.");
            return;
        }

        for (String r : queue) {
            System.out.println(r);
        }
    }
}