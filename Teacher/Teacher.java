package Teacher;

import java.util.ArrayList;
public class Teacher {
    private int teacherId;
    private String name;
    private String email;
    private String phone;

    private Department department;

    private ArrayList<Course> courses;
    private ArrayList<Supervision> supervisions;

    public Teacher(int teacherId, String name, String email, String phone, Department department) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;

        courses = new ArrayList<>();
        supervisions = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addSupervision(Supervision supervision) {
        supervisions.add(supervision);
    }


    public void showDetails() {
        System.out.println("          TEACHER DETAILS");
        System.out.println("Teacher ID : " + teacherId);
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Phone      : " + phone);

        System.out.println("\nDepartment:");
        department.showDepartment();

        System.out.println("\nCourses:");

        for (Course course : courses) {
            course.showCourse();
        }

        System.out.println("\nSupervisions:");

        for (Supervision supervision : supervisions) {
            supervision.showSupervision();
        }
    }
}