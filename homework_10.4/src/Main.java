import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company skillbox = new Company();
        ArrayList<Employee> managers = new ArrayList<>();
        ArrayList<Employee> operators = new ArrayList<>();
        ArrayList<Employee> topManagers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            Manager manager = new Manager();
            managers.add(manager);
        }
        skillbox.hireAll(managers);
        for (int i = 0; i <180; i++){
            Operator operator = new Operator();
            operators.add(operator);
        }
        skillbox.hireAll(operators);
        for (int i=0;i<15;i++){
            TopManager topManager = new TopManager();
            topManagers.add(topManager);
        }
        skillbox.hireAll(topManagers);
        skillbox.getTopSalaryStaff(15);
        System.out.println("Список из самых высоких зарплат:");
        for (Employee employee : skillbox.getTopSalaryStaff(15))
        {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("Список из самых низких зарплат:");
        for (Employee employee : skillbox.getLowestSalaryStaff(30)){
            System.out.println(employee.getMonthSalary());
        }
        System.out.println(skillbox.employees);
        for (int i=0;i<skillbox.employees.size()/2;i++)
            skillbox.fire(i);
        System.out.println(skillbox.employees);
        System.out.println("Список из самых высоких зарплат:");
        for (Employee employee : skillbox.getTopSalaryStaff(15))
        {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("Список из самых низких зарплат:");
        for (Employee employee : skillbox.getLowestSalaryStaff(30)){
            System.out.println(employee.getMonthSalary());
        }

    }

}
