import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDataAnalyzer analyzer = new StudentDataAnalyzer();

        List<String> sampleData = List.of(
                "1,John Doe,20,3.5",
                "2,Jane Smith,22,3.8",
                "3,Bob Johnson,19,3.2",
                "4,Alice Williams,21,3.9",
                "5,Tom Brown,23,3.1"
        );

        analyzer.loadStudents(sampleData);
        System.out.println("Average GPA: " + analyzer.calculateAverageGPA());


        System.out.println("Top 3 Students by GPA:");
        for (Student s : analyzer.getTopStudents(3)) {
            System.out.println(s);
        }

        System.out.println("Students aged between 20 and 22:");
        for (Student s : analyzer.getStudentsByAgeRange(20, 22)) {
            System.out.println(s);
        }
    }
}