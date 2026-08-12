package Student;

public class Department {
    private int departmentId;
    private String departmentName;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void showDepartment() {
        System.out.println("Department ID   : " + departmentId);
        System.out.println("Department Name : " + departmentName);
    }
}