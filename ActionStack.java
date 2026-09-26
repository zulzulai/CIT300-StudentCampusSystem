package structures;

import java.util.Stack;

public class ActionStack {
    private Stack<String> history = new Stack<>();

    public void push(String action) { history.push(action); }
    public String pop() { return history.isEmpty() ? null : history.pop(); }
    public String peek() { return history.isEmpty() ? null : history.peek(); }
    public void displayHistory() {
        if (history.isEmpty()) { System.out.println("No actions."); return; }
        for (int i = history.size() - 1; i >= 0; i--)
            System.out.println(history.get(i));
    }
}