package Operations;

import Classes.Faculty;
import Classes.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StudentOperations {
    private static final List<Student> students = Student.getStudentsList();
    private static final List<Faculty> faculties = Faculty.getFacultyList();
    public StudentOperations(Scanner scanner) {

        String input = null;
        while (!Objects.equals(input, "b")) {

            Menu.printStudentOperations();
            input = scanner.nextLine();
            ArrayList<String> clearInput = Remover.removeAllSlashes(input);

            switch (clearInput.get(0)){
                case "fd":
                    System.out.println("\nAll-time Students data:");
                    for (Student student : students) {
                            System.out.println(" - " + student.getFirstName() + " " + student.getLastName() +
                                    " | Date of Birth: " + student.getDay() + "." + student.getMonth() + "." + student.getYear() +
                                    " | Email: " + student.getEmail() +
                                    " | Faculty: " + student.getFacultyAbbreviation());
                    }
                    break;

                case "fe":
                    System.out.println("\nEnrolled students data:");
                    for (Student student : students) {
                        if(!student.isGraduated()){
                        System.out.println(" - " + student.getFirstName() + " " + student.getLastName() +
                                            " | Date of Birth: " + student.getDay() + "." + student.getMonth() + "." + student.getYear() +
                                            " | Email: " + student.getEmail() +
                                            " | Current faculty: " + student.getFacultyAbbreviation());
                        }
                    }
                    break;

                case "fg":
                    System.out.println("\nGraduate students data:");
                    for (Student student : students) {
                        if(student.isGraduated()){
                            System.out.println(" - " + student.getFirstName() + " " + student.getLastName() +
                                    " | Date of Birth: " + student.getDay() + "." + student.getMonth() + "." + student.getYear() +
                                    " | Email: " + student.getEmail() +
                                    " | Graduated faculty: " + student.getFacultyAbbreviation());
                        }
                    }
                    break;

                case "b":
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("\t\nInvalid input");
                    break;
            }
        }
    }
}