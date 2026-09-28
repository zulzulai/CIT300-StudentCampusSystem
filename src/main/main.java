package main;



import model.Student;
import structures.*;
import java.util.Scanner;

public class main {

    static StudentLinkedList list = new StudentLinkedList();
    static ActionStack stack = new ActionStack();
    static ServiceQueue queue = new ServiceQueue();
    static StudentBST bst = new StudentBST();
    static StudentHashTable hash = new StudentHashTable();
    static CampusGraph graph = new CampusGraph();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> list.displayAll();
                case 5 -> addServiceRequest();
                case 6 -> processService();
                case 7 -> stack.displayHistory();
                case 8 -> bst.inOrder();
                case 9 -> searchHash();
                case 10 -> addLocation();
                case 11 -> removeLocation();
                case 12 -> addConnection();
                case 13 -> removeConnection();
                case 14 -> graph.displayConnections();
                case 15 -> traverse();
                case 16 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 16);
    }

    static void printMenu() {
        System.out.println("\n===== UNIVERSITY SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Add Service Request");
        System.out.println("6. Process Next Request");
        System.out.println("7. Display Recent Actions");
        System.out.println("8. Display Students via BST");
        System.out.println("9. Search Student via Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection");
        System.out.println("13. Remove Campus Connection");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. BFS/DFS Traverse");
        System.out.println("16. Exit");
    }

    static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v < 0 || v > 100) { System.out.println("Marks must be 0-100."); continue; }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Invalid marks, try again.");
            }
        }
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    static void addStudent() {
        String id = readString("Student ID: ");
        if (list.searchStudent(id) != null) { System.out.println("Duplicate ID."); return; }
        String name = readString("Name: ");
        String prog = readString("Programme: ");
        double marks = readDouble("Marks (0-100): ");
        Student s = new Student(id, name, prog, marks);
        list.addStudent(s);
        bst.insert(s);
        hash.put(s);
        stack.push("Added student " + id);
        System.out.println("Student added.");
    }

    static void updateStudent() {
        String id = readString("Student ID to update: ");
        Student s = list.searchStudent(id);
        if (s == null) { System.out.println("Not found."); return; }
        String name = readString("New name (blank=skip): ");
        String prog = readString("New programme (blank=skip): ");
        String m = readString("New marks (blank=skip): ");
        double marks = m.isEmpty() ? -1 : Double.parseDouble(m);
        list.updateStudent(id, name.isEmpty() ? null : name,
                prog.isEmpty() ? null : prog, marks);
        stack.push("Updated student " + id);
        System.out.println("Updated.");
    }

    static void deleteStudent() {
        String id = readString("Student ID to delete: ");
        if (list.deleteStudent(id)) {
            hash.remove(id);
            stack.push("Deleted student " + id);
            System.out.println("Deleted.");
        } else System.out.println("Not found.");
    }

    static void addServiceRequest() {
        String req = readString("Request description: ");
        queue.enqueue(req);
        stack.push("Queued request: " + req);
        System.out.println("Request queued.");
    }

    static void processService() {
        String r = queue.dequeue();
        if (r == null) System.out.println("No pending requests.");
        else { System.out.println("Processed: " + r); stack.push("Processed: " + r); }
    }

    static void searchHash() {
        String id = readString("Student ID to search: ");
        Student s = hash.get(id);
        System.out.println(s != null ? s : "Not found.");
    }

    static void addLocation() {
        String n = readString("Location name: ");
        if (graph.addLocation(n)) { stack.push("Added location " + n); System.out.println("Added."); }
        else System.out.println("Location already exists.");
    }

    static void removeLocation() {
        String n = readString("Location to remove: ");
        if (graph.removeLocation(n)) { stack.push("Removed location " + n); System.out.println("Removed."); }
        else System.out.println("Not found.");
    }

    static void addConnection() {
        String a = readString("From: ");
        String b = readString("To: ");
        if (graph.addConnection(a, b)) { stack.push("Connected " + a + "-" + b); System.out.println("Connected."); }
        else System.out.println("Invalid or duplicate connection.");
    }

    static void removeConnection() {
        String a = readString("From: ");
        String b = readString("To: ");
        if (graph.removeConnection(a, b)) System.out.println("Removed.");
        else System.out.println("Not found.");
    }

    static void traverse() {
        String start = readString("Start location: ");
        System.out.print("BFS: "); graph.bfs(start);
        System.out.print("DFS: "); graph.dfs(start);
    }
}
