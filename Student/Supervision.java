package Student;

public class Supervision {
    private String supervisorName;
    private String topic;

    public Supervision(String supervisorName, String topic) {
        this.supervisorName = supervisorName;
        this.topic = topic;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public String getTopic() {
        return topic;
    }

    public void showSupervision() {
        System.out.println("Supervisor : " + supervisorName);
        System.out.println("Topic      : " + topic);
    }
}