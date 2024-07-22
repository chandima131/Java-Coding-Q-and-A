import java.util.ArrayList;
import java.util.List;

public class EmployeeManagment {
    public List<Employee> employees;

    public EmployeeManagment() {
         employees = new ArrayList<>();
    }

    // Add Employees as a array list
    public void addEmployee(Employee employee){
            employees.add(employee);
    }

    //To remove employee

    public void removeEmployee(int id){
    employees.removeIf(employee -> employee.getId() == id);
    }

    //To display employees
    public List<Employee> getEmployees(){
        return employees;
    }


    public static void main (String args[]){

        EmployeeManagment managment = new EmployeeManagment();

        Employee e1 = new Employee("chandima", "xyz", 1);
        Employee e2 = new Employee("shanis", "abc",2);
        Employee e3 = new Employee("har","efg",3);

        managment.addEmployee(e1);
        managment.addEmployee(e2);
        managment.addEmployee(e3);

        // to display after add
        System.out.println("employees after addition");
        for(Employee e : managment.getEmployees()){
            System.out.println(e);
        }

        managment.removeEmployee(2);

        // to display after removal
        System.out.println("\nemployees after remove");
        for(Employee e : managment.getEmployees()){
            System.out.println(e);
        }

    }
}
