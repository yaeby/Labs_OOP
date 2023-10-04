package Operations;

import Classes.Faculty;
import Classes.Student;
import Classes.StudyField;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GeneralOperations {
    private static final List<Student> students = Student.getStudentsList();
    private static final List<Faculty> faculties = Faculty.getFacultyList();
    public GeneralOperations(Scanner scanner) {

        String input = null;

        while (!Objects.equals(input, "b")) {

            Menu.printGeneralOperations();
            input = scanner.nextLine();
            ArrayList<String> clearInput = Remover.removeAllSlashes(input);

            switch (clearInput.get(0)) {
                case "nf":
                    if (clearInput.size() == 4) {
                        FileManager.writeData(input);
                        String facultyName = clearInput.get(1);
                        String facultyAbbreviation = clearInput.get(2);
                        StudyField studyField = StudyField.valueOf(clearInput.get(3));
                        Faculty faculty = new Faculty(facultyName, facultyAbbreviation, studyField);
                        Faculty.addFaculty(faculty);
                        System.out.println("\nFaculty created.");
                    } else {
                        System.out.println("\nInvalid input");
                    }
                    break;

                case "df":
                    System.out.println("\nAvailable faculties:");
                    for (Faculty faculty : faculties) {
                        System.out.println(" - " + faculty.getName());
                    }
                    break;

                case "dl":
                    if (clearInput.size() == 2) {
                        String field = clearInput.get(1);
                        if (StudyField.validation(field)) {
                            System.out.println("\nFaculties from the " + field + " field:");
                            for (Faculty faculty: faculties){
                                if (faculty.getStudyField().toString().equals(field)){
                                    System.out.println(" - " + faculty.getName());
                                }
                            }
                        } else {
                            System.out.println("\nInvalid field");
                        }
                    } else {
                        System.out.println("\nInvalid input");
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