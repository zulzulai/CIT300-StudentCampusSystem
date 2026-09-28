package structures;

import model.Student;

public class StudentLinkedList {

    private class Node {
        Student data;
        Node next;
        Node(Student data) { this.data = data; }
    }

    private Node head;

    public boolean addStudent(Student s) {
        if (searchStudent(s.getStudentId()) != null) {
            System.out.println("Duplicate ID!");
            return false;
        }
        Node newNode = new Node(s);
        if (head == null) { head = newNode; return true; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = newNode;
        return true;
    }

    public Student searchStudent(String id) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.getStudentId().equals(id)) return cur.data;
            cur = cur.next;
        }
        return null;
    }

    public boolean updateStudent(String id, String name, String prog, double marks) {
        Student s = searchStudent(id);
        if (s == null) return false;
        if (name != null) s.setName(name);
        if (prog != null) s.setProgramme(prog);
        if (marks >= 0) s.setMarks(marks);
        return true;
    }

    public boolean deleteStudent(String id) {
        if (head == null) return false;
        if (head.data.getStudentId().equals(id)) {
            head = head.next;
            return true;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.data.getStudentId().equals(id)) {
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void displayAll() {
        if (head == null) { System.out.println("No records."); return; }
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}