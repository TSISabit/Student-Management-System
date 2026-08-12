package Teacher;

public class Supervision {
    private String studentName;
    private String topic;

    public Supervision(String studentName, String topic) {
        this.studentName = studentName;
        this.topic = topic;
    }

    public void showSupervision() {
        System.out.println("Student : " + studentName);
        System.out.println("Topic   : " + topic);
    }
}