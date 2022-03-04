import java.util.*;

public class Company {
    private static int income = 1000000;
    public ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList<Employee> hire(Employee employee) {
        employees.add(employee);
        return employees;
    }

    public ArrayList<Employee> hireAll(ArrayList<Employee> employeesToAdd) {
        employees.addAll(employeesToAdd);
        return employees;
    }

    public ArrayList<Employee> fire(int index) {
        if (index + 1 <= employees.size())
            employees.remove(index);
        else
            System.out.println("Такого сотрудника не сущетсвует");
        return employees;
    }

    public static int getIncome() {
        return income;
    }

    private boolean countCheck(int count) {
        if ((count > 0) && (count <= employees.size()))
            return true;
        else return false;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (!countCheck(count)) {
            return new ArrayList<>();
        }
        List<Employee> topSalaryEmployee = new ArrayList<>(employees);
        topSalaryEmployee.sort(new EmployeeComporator());
        return topSalaryEmployee.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (!countCheck(count)) {
            return new ArrayList<>();
        }
        List<Employee> lowestSalaryEmployee = new ArrayList<>(employees);
        lowestSalaryEmployee.sort(new EmployeeComporator());

        return lowestSalaryEmployee.subList(lowestSalaryEmployee.size() - count, lowestSalaryEmployee.size());
    }


}
