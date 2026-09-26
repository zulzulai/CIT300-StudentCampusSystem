package structures;

import model.Student;
import java.util.LinkedList;

public class StudentHashTable {

    private static final int SIZE = 17;
    private LinkedList<Student>[] table;

    @SuppressWarnings("unchecked")
    public StudentHashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) table[i] = new LinkedList<>();
    }

    private int hash(String id) {
        return Math.abs(id.hashCode()) % SIZE;
    }

    public void put(Student s) {
        int idx = hash(s.getStudentId());
        for (Student st : table[idx])
            if (st.getStudentId().equals(s.getStudentId())) return;
        table[idx].add(s);
    }

    public Student get(String id) {
        for (Student s : table[hash(id)])
            if (s.getStudentId().equals(id)) return s;
        return null;
    }

    public boolean remove(String id) {
        int idx = hash(id);
        return table[idx].removeIf(s -> s.getStudentId().equals(id));
    }
}
