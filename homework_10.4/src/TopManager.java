public class TopManager implements Employee{
    private int monthDefaultSalary = (int) (100000 + Math.random()*1000);
    @Override
    public int getMonthSalary() {
        int monthSalary;
        if (Company.getIncome()>10000000)
        monthSalary = (int) (2.5*100000);
        else
            monthSalary = monthDefaultSalary;
        return monthSalary;
    }
}
