package Student;

public class Waiver {
    private double percentage;

    public Waiver(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public double calculateWaiver(double tuitionFee) {
        return tuitionFee * percentage / 100.0;
    }

    public void showWaiver(double tuitionFee) {
        double waiverAmount = calculateWaiver(tuitionFee);

        System.out.println("Waiver Percentage : " + percentage + "%");
        System.out.println("Waiver Amount     : " + waiverAmount);
    }
}