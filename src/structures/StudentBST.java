package structures;

import model.Student;

public class StudentBST {

    private class Node {
        Student data;
        Node left, right;
        Node(Student data) { this.data = data; }
    }

    private Node root;

    public void insert(Student s) { root = insertRec(root, s); }
    private Node insertRec(Node root, Student s) {
        if (root == null) return new Node(s);
        if (s.getStudentId().compareTo(root.data.getStudentId()) < 0)
            root.left = insertRec(root.left, s);
        else if (s.getStudentId().compareTo(root.data.getStudentId()) > 0)
            root.right = insertRec(root.right, s);
        return root;
    }

    public Student search(String id) {
        Node cur = root;
        while (cur != null) {
            int cmp = id.compareTo(cur.data.getStudentId());
            if (cmp == 0) return cur.data;
            cur = cmp < 0 ? cur.left : cur.right;
        }
        return null;
    }

    public void inOrder() { inOrderRec(root); }
    private void inOrderRec(Node node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.println(node.data);
        inOrderRec(node.right);
    }
}