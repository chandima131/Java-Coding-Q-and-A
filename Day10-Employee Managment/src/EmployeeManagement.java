import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {

    List<Employee> employees = new ArrayList<>();

    //To add employee
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    //To remove data
    public void removeEmployee(int id){
        employees.removeIf(employee -> employee.getId() == id);
    }
    //To display data

    public List<Employee> getEmployees(){
        return employees;
    }


    public static void main(String args[]){

        EmployeeManagement management = new EmployeeManagement();

        Employee e1 = new Employee(1,"chandima", "xyz");

        management.addEmployee(e1);

        //To display after adding
        System.out.println("to display after adding");

        for (Employee employee : management.getEmployees()){
            System.out.println(employee);
        }


        management.removeEmployee(1);
        //To display after adding
        System.out.println("to display after removing");

        for (Employee employee : management.getEmployees()){
            System.out.println(employee);
        }
    }
}
