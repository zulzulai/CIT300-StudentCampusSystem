# University Student Record and Campus Route Management System

**Module:** CIT300 – Data Structures and Algorithms  
**Assignment:** Graded Practical Assignment 1 (Week 10)  
**Contribution:** 10% of final module grade  
**Deadline:** 29th September  
**Language:** Java (Console Application)

---

## 1. Group Members
Member	Name	Student ID	Assigned Responsibility	Individual Contribution
Member 1	 M.N Rifa	23da2-0502	Linked List + Student Record Management	Implemented `StudentLinkedList.java`, `Student.java`, add/update/delete/search/display operations, validation for duplicate IDs and marks
Member 2	A.F Sihnas	23da2-0513	Stack + Queue	Implemented `ActionStack.java` and `ServiceQueue.java`, action history tracking, service request processing
Member 3	J.H Zulaiha	23da2-0778	BST/AVL + Hashing	Implemented `StudentBST.java` and `StudentHashTable.java`, sorted display, hash lookup
Member 4	M.N.F Rizma	23da2-0482	Graph + BFS/DFS	Implemented `CampusGraph.java`, `CampusLocation.java`, add/remove locations and connections, BFS and DFS traversal
All Members	           —	             —	Integration, validation, testing, debugging, documentation, GitHub collaboration	Merged all components into `Main.java`, tested all 16 menu options, prepared README and demo video


---

## 2. Project Description

This is a Java console application that manages **university student records** and **campus locations/connections**. It demonstrates the practical use of six data structures:

1. **Linked List** – stores and manages all student records
2. **Stack** – tracks recent actions (add, update, delete, queue, graph operations)
3. **Queue** – manages student service requests in arrival order
4. **BST (Binary Search Tree)** – organizes students by Student ID and displays them in sorted order
5. **Hashing** – provides fast Student ID lookup
6. **Graph** – models campus locations and roads using an adjacency list, with BFS and DFS traversal

All operations are accessed through a **menu-driven console interface** with input validation.

---

## 3. Data Structures Used

| Data Structure | File | Purpose |
|----------------|------|---------|
| Linked List | `structures/StudentLinkedList.java` | Store, update, delete, search student records |
| Stack | `structures/ActionStack.java` | Track recent actions / history |
| Queue | `structures/ServiceQueue.java` | Process service requests in FIFO order |
| BST | `structures/StudentBST.java` | Sorted display and search by Student ID |
| Hash Table | `structures/StudentHashTable.java` | Efficient lookup by Student ID |
| Graph (Adjacency List) | `structures/CampusGraph.java` | Campus locations, connections, BFS/DFS |

---

## 4. Project Structure

CIT300_StudentCampusSystem/
├── src/
│ ├── main/
│ │ └── Main.java
│ ├── model/
│ │ ├── Student.java
│ │ └── CampusLocation.java
│ ├── structures/
│ │ ├── StudentLinkedList.java
│ │ ├── ActionStack.java
│ │ ├── ServiceQueue.java
│ │ ├── StudentBST.java
│ │ ├── StudentHashTable.java
│ │ └── CampusGraph.java
│ └── service/
│ └── StudentService.java
├── README.md
└── .gitignore


---

## 5. Features

- Add, update, delete, search, and display student records
- Track recent actions using a stack
- Add and process student service requests using a queue
- Display students in sorted order using a BST
- Fast Student ID search using hashing
- Add and remove campus locations
- Add and remove connections (roads) between locations
- Display campus network (adjacency list)
- BFS and DFS traversal of the campus graph
- Input validation (duplicate IDs, invalid marks, missing records, invalid choices)
- Menu-driven console interface

---

## 6. How to Run

### Run in Eclipse (Recommended)

1. Open Eclipse → **File → Import → General → Existing Projects into Workspace**
2. Select the project folder `CIT300_StudentCampusSystem`
3. Click **Finish**
4. Open `src/main/Main.java`
5. Press **Ctrl + F11** (or click the green Run button)
6. The menu appears in the Console view

### Run from Terminal

```bash
cd CIT300_StudentCampusSystem/src
javac main/Main.java model/*.java structures/*.java service/*.java
java main.Main

---

## Requirements
Java JDK 11 or later

Eclipse IDE (optional)

---

## 7. Menu Overview

===== UNIVERSITY SYSTEM =====
1.  Add Student
2.  Update Student
3.  Delete Student
4.  Display All Students (Linked List)
5.  Add Service Request (Queue)
6.  Process Next Service Request
7.  Display Recent Actions (Stack)
8.  Display Students via BST
9.  Search Student via Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection
13. Remove Campus Connection
14. Display Campus Connections
15. BFS/DFS Traverse Campus
16. Exit
---

