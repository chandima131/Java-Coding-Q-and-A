import java.util.List;

public class EmployeeManagement {

    public void addEmployee(Employee employee){
        employees.add(employee);
    };

    public void removeEmployee(int id){

    };

    public List<Employee> getEmployees(){

        return List.of();
    }

    public static void main(String args[]){
        EmployeeManagement management = new EmployeeManagement();

        Employee e1 = new Employee(1, "Alice", "HR");
        Employee e2 = new Employee(2, "Bob", "Engineering");
        Employee e3 = new Employee(3, "Charlie", "Marketing");

        management.addEmployee(e1);
        management.addEmployee(e2);
        management.addEmployee(e3);

    }
}
