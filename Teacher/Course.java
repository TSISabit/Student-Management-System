package Teacher;

public class Course {
    private String courseCode;
    private String courseName;
    private int credit;

    public Course(String courseCode, String courseName, int credit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
    }

    public void showCourse() {
        System.out.println(courseCode + " - " + courseName + " (" + credit + " credits)");
    }
}