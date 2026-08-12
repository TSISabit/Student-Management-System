package Student;

public class Result {
    private String courseCode;
    private double marks;
    private String grade;

    public Result(String courseCode, double marks, String grade) {
        this.courseCode = courseCode;
        this.marks = marks;
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    public void showResult() {
        System.out.println( courseCode + " | Marks: " + marks + " | Grade: " + grade);
    }
}