package com.dp.hrank.java;

import java.util.*;

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<StudentPriorty> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (StudentPriorty st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class StudentPriorty {
    private int id;
    private String name;
    private double cgpa;

    public StudentPriorty(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCgpa() {
        return this.cgpa;
    }
}

class Priorities {

    Comparator comparator = (Comparator<StudentPriorty>) (s1, s2) -> {
        if (s1.getCgpa() == s2.getCgpa()) {
            if (s1.getName().equals(s2.getName())) {
                return s1.getId() - s2.getId();
            } else {
                return s1.getName().compareTo(s2.getName());
            }

        } else {
            return (int) (s1.getCgpa() - s2.getCgpa());
        }
    };

    /* Java 7 Style
    Comparator comparator = new Comparator<StudentPriorty>() {

        @Override
        public int compare(StudentPriorty s1, StudentPriorty s2) {
            if(s1.getCgpa() == s2.getCgpa()){
                if(s1.getName().equals(s2.getName())){
                    return s1.getId() - s2.getId();
                }else{
                    return s1.getName().compareTo(s2.getName());
                }

            }else{
                return (int) (s1.getCgpa() - s2.getCgpa());
            }
        }
    };*/
/*

    PriorityQueue<StudentPriorty> priorityQueue = new PriorityQueue<>(Comparator.comparing (StudentPriorty::getCgpa).reversed()
            .thenComparing(StudentPriorty::getName)
            .thenComparing(StudentPriorty::getId));

*/

    PriorityQueue<StudentPriorty> priorityQueue = new PriorityQueue<>(comparator);

    public List<StudentPriorty> getStudents(List<String> events) {
        for (String event : events) {
            StringTokenizer tokenizer = new StringTokenizer(event," ");
            String action = tokenizer.nextToken();

            if (action.equals("ENTER")) {
                String name = tokenizer.nextToken();
                double cgpa = Double.parseDouble(tokenizer.nextToken());
                int id = Integer.parseInt(tokenizer.nextToken());
                StudentPriorty s1 = new StudentPriorty(id, name, cgpa);
                priorityQueue.add(s1);
            }
            else if(action.equals("SERVED"))
                priorityQueue.remove();

        }
        return new ArrayList<StudentPriorty>(priorityQueue);

    }

}

/*Solution from  other
Note need to take each element out and insert it back for re-balancing

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student {
	private int token;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getName() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class Priorities {
	public List < Student > getStudents(List < String > events) {
		PriorityQueue < Student > student_queue = new PriorityQueue(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getToken));
		List < Student > students = new ArrayList < Student > ();
		for (String e: events) {
			Scanner in =new Scanner(e);
			String event = in.next();
			if (event.equals("ENTER")) {
				String name = in.next();
				float cgpa = in.nextFloat();
				int token = in.nextInt();

				Student student = new Student(token, name, cgpa);
				student_queue.add(student);
			} else if (event.equals("SERVED")) {
				Student first = student_queue.poll();
			} in .close();
		}
		Student first = student_queue.poll();
		if (first == null) {
			return students;
		} else {
			while (first != null) {

				students.add(first);
				first = student_queue.poll();

			}
			return students;
		}

	}
}
*/
