package Student;

public class TuitionFees {
    private double totalFee;
    private double paidFee;

    public TuitionFees(double totalFee, double paidFee) {
        this.totalFee = totalFee;
        this.paidFee = paidFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getPaidFee() {
        return paidFee;
    }

    public double getDueFee() {
        return totalFee - paidFee;
    }

    public void showFees() {
        System.out.println("Total Fee : " + totalFee);
        System.out.println("Paid Fee  : " + paidFee);
        System.out.println("Due Fee   : " + getDueFee());
    }
}