package com.udemy.sarha.List;

import com.udemy.sarha.Employee;

import java.util.*;

/**
 *
 */
public class EmployeeLinkList {

    public static void main(String... args) {
//        arrayListDemo();

//        VectorDemo();


//        singlelyLinkedList();

//        myDoublyLinkedList();

//        javaLinkList();

        EmployeeDoublyLinkedList dl = new EmployeeDoublyLinkedList();
        dl.addToFront(new Employee(11, "Hari", "thapa"));
        dl.addToFront(new Employee(10,"Dipen","lama"));
        dl.addToFront(new Employee(12,"Sunny","lama"));
        dl.addBefore(new Employee(11, "Hari", "thapa"),new Employee(12, "Shyam", "thapa"));
        dl.printList();


    }

    private static void javaLinkList() {
        LinkedList<Employee> linkedList = new LinkedList<>();

        linkedList.addFirst(new Employee(10,"Dipen","Lama"));
        linkedList.addFirst(new Employee(11,"Haru","Lama"));

        Iterator it = linkedList.iterator();
        System.out.print("head =>");
        while(it.hasNext()){
            System.out.print(it.next());
            System.out.print("<>");
        }
        System.out.print("null");
    }

    private static void myDoublyLinkedList() {
        EmployeeDoublyLinkedList dl = new EmployeeDoublyLinkedList();
        dl.addToFront(new Employee(10,"Dipen","lama"));
        dl.addToFront(new Employee(11, "Hari", "thapa"));
        dl.addToFront(new Employee(12, "Shyam", "thapa"));

        dl.printList();
        System.out.println("");
        System.out.println("size of dl" + dl.size);
        System.out.println("Add To the end of linkList ");

        dl.addToEnd(new Employee(15, "Test","Test"));
        dl.printList();
        System.out.println("New Size " + dl.size);

        dl.removeFromFront();
        System.out.println("Size after remove from front"+ dl.size);
        dl.printList();

        dl.removeFromEnd();
        System.out.println("Size after remove from end" + dl.size);
        dl.printList();
    }


    /**
     * Vector is similar to ArrayList but it is synchronized
     */
    private static void VectorDemo() {
        List<Employee> employeeVector = new Vector<>();
        employeeVector.add(new Employee(10, "Dipen", "Lama"));
        employeeVector.add(new Employee(11, "Ram", "rai"));
        employeeVector.add(new Employee(12, "Hari", "shrestha"));
    }

    private static void arrayListDemo() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, "Dipen", "lama"));
        employeeList.add(new Employee(11, "Ram", "Thapa"));
        employeeList.add(new Employee(12, "Shyam", "Rai"));
        employeeList.add(new Employee(13, "Hari", "lama"));

        employeeList.stream().forEach(employee -> System.out.println(employee));
        System.out.println(employeeList.get(0));
        System.out.println(employeeList.size());
        employeeList.set(1, new Employee(100, "Sunita", "Basi"));

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
    }

    private static void singlelyLinkedList() {
        EmployeeLinkedList employeeLinkedList  = new EmployeeLinkedList();
        employeeLinkedList.addToFront(new EmployeeNode(new Employee(1,"Dipen", "Lama")));
        employeeLinkedList.addToFront(new EmployeeNode(new Employee(2,"Hari", "Karki")));
        employeeLinkedList.printList();
    }
}


/**
 * This is node to store the obeject and reference to next node
 */
class EmployeeNode{
    private Employee employee;
    private EmployeeNode next;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}

class EmployeeLinkedList{
    private EmployeeNode head;
    private int size;
    public void addToFront(EmployeeNode employeeNode) {
        EmployeeNode node = employeeNode;
        node.setNext(head);
        head = node;
        size++;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}

class EmployeeDoublyLinkedList{

    private EmployeeNodeDoubly head;
    private EmployeeNodeDoubly tail;
    int size;

    public void addToFront(Employee employee) {
        EmployeeNodeDoubly node = new EmployeeNodeDoubly(employee);
        node.setNext(head);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
        }
        head = node;
        size++;

    }

    public void addToEnd(Employee employee) {
        EmployeeNodeDoubly node = new EmployeeNodeDoubly(employee);

        if (tail == null) {
            head = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
    }

    public void removeFromFront() {
        if (head == null) {
            return;
        }
        EmployeeNodeDoubly nodeRemove = head;

        if(head.getNext() == null){
            tail = null;
        }else{
            head.getNext().setPrevious(nodeRemove.getPrevious());
        }
        head = head.getNext();
        size--;
        nodeRemove.setNext(null);
    }

    public void removeFromEnd() {
        if (tail == null) {
            return;
        }
        EmployeeNodeDoubly nodeRemove = tail;

        if (tail.getPrevious() == null) {
            head = null;
        }else{
            tail.getPrevious().setNext(tail.getNext());
        }

        tail = nodeRemove.getPrevious();
        nodeRemove.setPrevious(null);
        size--;
    }

    public boolean addBefore(Employee e1, Employee e2) {
        if(head == null){
            return false;
        }
        EmployeeNodeDoubly current = head;
        while (head != null && current.getEmployee().equals(e1)){
            current = current.getNext();
        }
        if(current == null ){
            return false;
        }
        EmployeeNodeDoubly newNode = new EmployeeNodeDoubly(e2);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);
        if(head.equals(current)){
           // head = newNode;
        }else{

            current.getPrevious().setNext(newNode);
        }
        size++;
        return true;
    }

    public EmployeeNodeDoubly getHead() {
        return head;
    }

    public void setHead(EmployeeNodeDoubly head) {
        this.head = head;
    }

    public EmployeeNodeDoubly getTail() {
        return tail;
    }

    public void setTail(EmployeeNodeDoubly tail) {
        this.tail = tail;
    }

    public void printList() {
        EmployeeNodeDoubly current = head;
        System.out.println("Head -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <ß> ");
            current = current.getNext();
        }
    }

}

class EmployeeNodeDoubly{
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private Employee employee;
    private EmployeeNodeDoubly next;
    private EmployeeNodeDoubly previous;
    private int size;

    public EmployeeNodeDoubly(Employee employee) {
        this.employee = employee;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public EmployeeNodeDoubly getNext() {
        return next;
    }

    public void setNext(EmployeeNodeDoubly next) {
        this.next = next;
    }

    public EmployeeNodeDoubly getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNodeDoubly previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "employee=" + employee;
    }
}