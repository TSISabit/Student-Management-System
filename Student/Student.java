package Student;

import java.io.*;
import java.util.ArrayList;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String phone;

    private Department department;
    private TuitionFees tuitionFees;
    private Waiver waiver;
    private Supervision supervision;

    private ArrayList<Course> courses;
    private ArrayList<Result> results;

    private static final String STUDENT_FILE = "student.csv";
    private static final String RESULT_FILE = "result.txt";

    public Student(int studentId, String name, String email, String phone, Department department) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;

        courses = new ArrayList<>();
        results = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public void setTuitionFees(TuitionFees tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public void setWaiver(Waiver waiver) {
        this.waiver = waiver;
    }

    public void setSupervision(Supervision supervision) {
        this.supervision = supervision;
    }

    public class StudentContact {

        private String emergencyContact;
        private String relationship;

        public StudentContact(String emergencyContact, String relationship) {
            this.emergencyContact = emergencyContact;
            this.relationship = relationship;
        }

        public void showContact() {
            System.out.println("Emergency Contact : " + emergencyContact);
            System.out.println("Relationship      : " + relationship);
        }
    }

    public void showdetails() {
        System.out.println("          STUDENT DETAILS");
        System.out.println("====================================");

        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Phone      : " + phone);

        System.out.println();

        if (department != null) {
            department.showDepartment();
        }

        System.out.println("\nCourses:");

        if (courses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (Course course : courses) {
                course.showCourse();
            }
        }

        if (tuitionFees != null) {
            System.out.println("\nTuition Fees:");
            tuitionFees.showFees();
        }

        if (waiver != null) {
            System.out.println("\nWaiver:");
            waiver.showWaiver(tuitionFees != null ? tuitionFees.getTotalFee() : 0);
        }

        if (supervision != null) {
            System.out.println("\nSupervision:");
            supervision.showSupervision();
        }

        System.out.println("====================================");
    }

    public void showresult() {
        System.out.println("           STUDENT RESULT");
        System.out.println("====================================");

        if (results.isEmpty()) {
            System.out.println("No result available.");
        } else {
            for (Result result : results) {
                result.showResult();
            }
        }

        System.out.println("====================================");
    }

    public static void enterstudent(Student student) {

        try {
            File file = new File(STUDENT_FILE);
            boolean newFile = !file.exists();
            FileWriter writer = new FileWriter(file, true);
            if (newFile) {
                writer.write("StudentID,Name,Email,Phone,Department\n");
            }
            writer.write(student.studentId + "," + student.name + "," + student.email + "," + student.phone + "," + student.department.getDepartmentName() + "\n");
            writer.close();

            System.out.println( "\nStudent saved successfully!");

        } catch (IOException e) {
            System.out.println("Error while saving student.");
            System.out.println("Reason: " + e.getMessage());
        }
    }
    public static void removestudent(int id) {
        File inputFile = new File(STUDENT_FILE);
        File tempFile = new File("temp.csv");
        boolean found = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("StudentID")) {
                    writer.write(line);
                    writer.newLine();
                    continue;
                }

                String[] data = line.split(",");

                if (data.length > 0) {
                    int currentId = Integer.parseInt(data[0]);
                    if (currentId == id) {
                        found = true;
                        continue;
                    }
                }

                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            if (!inputFile.delete()) {
                throw new IOException("Unable to delete old student file.");
            }

            if (!tempFile.renameTo(inputFile)) {
                throw new IOException("Unable to create updated student file.");
            }

            if (found) {
                System.out.println("Student removed successfully.");
            } 
            
            else {
                System.out.println("Student ID not found.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("student.csv file does not exist."
            );

        } catch (NumberFormatException e) {
            System.out.println("Invalid student ID in CSV file.");

        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }

    public void saveResult() {
        try {
            FileWriter writer = new FileWriter(RESULT_FILE, true);

            writer.write("Student ID: " + studentId + "\n");

            writer.write("Name: " + name + "\n");

            for (Result result : results) {
                writer.write(result.getCourseCode() + " | Marks: " + result.getMarks() + " | Grade: " + result.getGrade() + "\n");
            }

            writer.write(
                    "------------------------------------\n"
            );

            writer.close();

            System.out.println("Result saved to result.txt");

        } catch (IOException e) {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }
}