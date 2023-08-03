package RDG_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    private int id;
    private String name;
    private String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // Геттеры и сеттеры...
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}

interface StudentDao {
    List<Student> getAllStudents();
    Student getStudent(int id);
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}

class StudentDaoImpl implements StudentDao {
    private List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void insertStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        Student existingStudent = getStudent(student.getId());
        if (existingStudent != null) {
            int index = students.indexOf(existingStudent);
            students.set(index, student);
        }
    }

    @Override
    public void deleteStudent(Student student) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student existingStudent = iterator.next();
            if (existingStudent.getId() == student.getId()) {
                iterator.remove();
                return;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        Student student1 = new Student(1, "Alice", "Computer Science");
        Student student2 = new Student(2, "Bob", "Physics");

        studentDao.insertStudent(student1);
        studentDao.insertStudent(student2);

        for (Student student : studentDao.getAllStudents()) {
            System.out.println(student.getName());
        }

        System.out.println(studentDao.getStudent(1).getName());

        studentDao.updateStudent(new Student(1, "Alicia", "Computer Science"));
        System.out.println(studentDao.getStudent(1).getName());

        studentDao.deleteStudent(student1);
        for (Student student : studentDao.getAllStudents()) {
            System.out.println(student.getName());
        }
    }
}