import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StudentDataAnalyzer {


    private List<Student> students;

    public StudentDataAnalyzer() {
        students = new ArrayList<>();
    }

    //load students

    public void loadStudents(List<String> studentData) {
        for (String data : studentData) {
            String[] parts = data.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int age = Integer.parseInt(parts[2]);
            double gpa = Double.parseDouble(parts[3]);

            students.add(new Student(id, name, age, gpa));
        }
    }


    public double calculateAverageGPA() {
        return students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }


    public List<Student> getTopStudents(int n) {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByAgeRange(int minAge, int maxAge) {
        return students.stream()
                .filter(s -> s.getAge() >= minAge && s.getAge() <= maxAge)
                .collect(Collectors.toList());
    }


}
