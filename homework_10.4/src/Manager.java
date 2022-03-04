public class Manager implements Employee {
    private int monthDefaultSalary = 50000;

    @Override
    public int getMonthSalary() {
        int monthSalary = monthDefaultSalary + (int) (0.05*(115000 + Math.random() * 25000));
        return monthSalary;
    }
}
