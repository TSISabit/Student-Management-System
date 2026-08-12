import Student.Student;
import Student.Department;
import Student.Course;
import Student.Result;
import Student.Waiver;
import Student.TuitionFees;
import Student.Supervision;

public class Main {
    public static void main(String[] args) {
        try {
            Department cse = new Department(101, "Computer Science and Engineering");
            Student student = new Student(1001, "Sabit", "sabit@gmail.com", "01700000000", cse);

            Course java = new Course("CSE301", "Java Programming", 3);

            Course database = new Course("CSE302", "Database Management", 3);

            student.addCourse(java);
            student.addCourse(database);

            Result result1 = new Result("CSE301",85);

            Result result2 = new Result("CSE302", 78 );

            student.addResult(result1);
            student.addResult(result2);

            TuitionFees fees = new TuitionFees(50000, 30000);

            student.setTuitionFees(fees);

            Waiver waiver = new Waiver(20);

            student.setWaiver(waiver);

            Supervision supervision = new Supervision("Dr. Rahman", "Student Management System");

            student.setSupervision(supervision);

            Student.StudentContact contact =student.new StudentContact("01800000000", "Brother");

            student.showdetails();

            System.out.println( "\nEmergency Contact:");

            contact.showContact();

            student.showresult();
            
            Student.enterstudent(student);

            student.saveResult();
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }
}