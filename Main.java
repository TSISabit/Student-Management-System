import java.util.Scanner;

import Student.Student;
import Student.Department;
import Student.Course;
import Student.Result;
import Student.Waiver;
import Student.TuitionFees;
import Student.Supervision;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Student student = null;

        while (true) {
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Add Result");
            System.out.println("4. Show Result");
            System.out.println("5. Save Result");
            System.out.println("6. Remove Student");
            System.out.println("7. Emergency Contact");
            System.out.println("8. Exit");
            System.out.println("\n");

            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        student = addStudent();
                        break;

                    case 2:
                        if (student == null) System.out.println("Please add a student first.");
                        else student.showdetails();
                        break;

                    case 3:
                        if (student == null) System.out.println("Please add a student first.");
                        else addResult(student);
                        break;

                    case 4:
                        if (student == null) System.out.println("Please add a student first.");
                        else student.showresult();
                        break;

                    case 5:
                        if (student == null) System.out.println("Please add a student first.");
                        else student.saveResult();
                        break;

                    case 6:
                        removeStudent();
                        break;

                    case 7:
                        if (student == null) System.out.println("Please add a student first.");
                        else showEmergencyContact(student);
                        break;

                    case 8:
                        System.out.println("Thank you for using Student Management System!");
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Enter 1-8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");

            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static Student addStudent() {
        try {
            System.out.println("ADD STUDENT");
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Enter Student Name: ");
            String name = input.nextLine();

            System.out.print("Enter Email: ");
            String email = input.nextLine();

            System.out.print("Enter Phone: ");
            String phone = input.nextLine();

            System.out.print("Enter Department ID: ");
            int departmentId = Integer.parseInt(input.nextLine());

            System.out.print("Enter Department Name: ");
            String departmentName = input.nextLine();

            Department department = new Department(departmentId, departmentName);

            Student student = new Student(id, name, email, phone, department);

            System.out.print("\nEnter Course Code: ");
            String courseCode = input.nextLine();

            System.out.print("Enter Course Name: ");
            String courseName = input.nextLine();

            System.out.print("Enter Course Credit: ");
            int credit = Integer.parseInt(input.nextLine());

            student.addCourse(
                    new Course(courseCode, courseName, credit)
            );

            System.out.print("Add another course? (y/n): ");

            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                System.out.print("Enter Course Code: ");
                courseCode = input.nextLine();

                System.out.print("Enter Course Name: ");
                courseName = input.nextLine();

                System.out.print("Enter Course Credit: ");
                credit = Integer.parseInt(input.nextLine());

                student.addCourse(new Course(courseCode, courseName, credit));
            }

            System.out.print("\nEnter Total Tuition Fee: ");
            double totalFee = Double.parseDouble(input.nextLine());

            System.out.print("Enter Paid Fee: ");
            double paidFee = Double.parseDouble(input.nextLine());

            if (paidFee > totalFee) {
                throw new IllegalArgumentException("Paid fee cannot be greater than total fee.");
            }

            student.setTuitionFees(new TuitionFees(totalFee, paidFee));

            System.out.print("Enter Waiver Percentage: ");
            double waiverPercentage = Double.parseDouble(input.nextLine());

            if (waiverPercentage < 0 || waiverPercentage > 100) {
                throw new IllegalArgumentException("Waiver must be between 0 and 100.");
            }

            student.setWaiver(new Waiver(waiverPercentage));

            System.out.print("\nEnter Supervisor Name: ");
            String supervisor = input.nextLine();

            System.out.print("Enter Supervision Topic: ");
            String topic = input.nextLine();

            student.setSupervision( new Supervision(supervisor, topic));

            Student.enterstudent(student);

            System.out.println("Student created successfully!");

            return student;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public static void addResult(Student student) {
        try {
            System.out.print("Enter Course Code: ");
            String courseCode = input.nextLine();

            System.out.print("Enter Marks: ");
            double marks = Double.parseDouble(input.nextLine());

            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }

            Result result = new Result(courseCode, marks);

            student.addResult(result);

            System.out.println("Result added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid marks!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void removeStudent() {
        try {
            System.out.println("\n REMOVE STUDENT");
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(input.nextLine());

            Student.removestudent(id);

        } catch (NumberFormatException e) {
            System.out.println( "Invalid Student ID!");
        }
    }

    public static void showEmergencyContact(Student student) {
        System.out.println("\nEMERGENCY CONTACT");

        System.out.print("Enter Emergency Contact: ");

        String contact = input.nextLine();

        System.out.print("Enter Relationship: ");

        String relationship = input.nextLine();

        Student.StudentContact emergencyContact = student.new StudentContact(contact, relationship);
        emergencyContact.showContact();
    }
}