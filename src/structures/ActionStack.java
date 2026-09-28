package structures;


import java.util.Stack;

public class ActionStack {

    private Stack<String> history = new Stack<>();

    public void push(String action) {
        history.push(action);
    }

    public String pop() {
        if (history.isEmpty()) {
            return null;
        }

        return history.pop();
    }

    public String peek() {
        if (history.isEmpty()) {
            return null;
        }

        return history.peek();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No actions.");
            return;
        }

        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }
}