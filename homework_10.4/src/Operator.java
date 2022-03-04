public class Operator implements Employee{
   private int monthSalary = (int) (Math.random() *1000 + 50000);
    @Override
    public int getMonthSalary() {
        return monthSalary;
    }
}
