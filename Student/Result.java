package Student;
public class Result {
    private String courseCode;
    private double marks;
    private String grade;
    public Result(String courseCode, double marks) {
        this.courseCode = courseCode;
        this.marks = marks;
        if (marks >= 80) grade = "A+";
        else if (marks >= 75) grade = "A";
        else if (marks >= 70) grade = "A-";
        else if (marks >= 65) grade = "B+";
        else if (marks >= 60) grade = "B";
        else if (marks >= 55) grade = "B-";
        else if (marks >= 50) grade = "C";
        else if (marks >= 40) grade = "D";
        else grade = "F";
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
        System.out.println(courseCode + " | Marks: " + marks + " | Grade: " + grade);
    }
}