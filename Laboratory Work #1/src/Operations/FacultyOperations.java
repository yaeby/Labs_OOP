package Operations;

import Classes.Faculty;
import Classes.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FacultyOperations {
    private static final List<Student> students = Student.getStudentsList();
    private static final List<Faculty> faculties = Faculty.getFacultyList();
    public FacultyOperations(Scanner scanner) {

        String input = null;
        while (!Objects.equals(input, "b")) {

            Menu.printFacultyOperations();
            input = scanner.nextLine();
            ArrayList<String> clearInput = Remover.removeAllSlashes(input);

            switch (clearInput.get(0)){
                case "ns":
                    if (clearInput.size() == 8) {
                        FileManager.writeData(input);
                        String facultyAbbreviation = clearInput.get(1);
                        String studentFirstName = clearInput.get(2);
                        String studentLastName = clearInput.get(3);
                        String email = clearInput.get(4);
                        int birthDay = Integer.parseInt(clearInput.get(5));
                        int birthMonth = Integer.parseInt(clearInput.get(6));
                        int birthYear = Integer.parseInt(clearInput.get(7));
                        Faculty faculty = Faculty.findFacultyByAbbreviation(faculties, facultyAbbreviation);
                        if (faculty != null) {
                            Student student = new Student(studentFirstName, studentLastName, email, birthDay, birthMonth, birthYear, facultyAbbreviation);
                            Student.addStudent(student);
                            student.linkWithFaculty(faculty);
                            faculty.addStudent(student);
                            System.out.println("\nStudent enrolled.");
                        } else {
                            System.out.println("\nInvalid abbreviation: '" + facultyAbbreviation);
                        }
                    } else {
                        System.out.println("\nInvalid input");
                    }
                    break;

                case "gs":
                    if (clearInput.size() == 2) {
                        FileManager.writeData(input);
                        String email = clearInput.get(1);
                        for (Student student : students) {
                            if (student.getEmail().equals(email)) {
                                student.graduate();
                                System.out.println("\n" + email + " has graduated.");
                                return;
                            }
                        }
                        System.out.println("\n" + email + " not found.");
                    } else {
                        System.out.println("\nInvalid input");
                    }
                    break;

                case "ds":
                    if (clearInput.size() == 2) {
                        String facultyAbbreviation = clearInput.get(1);
                        System.out.println("\nEnrolled students at faculty " + facultyAbbreviation + ":");
                        for (Student student : students) {
                            if (student.getFacultyAbbreviation().equals(facultyAbbreviation) && !student.isGraduated()) {
                                System.out.println(" - " + student.getEmail());
                            }
                        }
                    } else {
                        System.out.println("\nInvalid input");
                    }
                    break;

                case "dg":
                    if (clearInput.size() == 2) {
                        String facultyAbbreviation = clearInput.get(1);
                        System.out.println("\nStudents that graduated faculty " + facultyAbbreviation + ":");
                        for (Student student : students) {
                            if (student.getFacultyAbbreviation().equals(facultyAbbreviation) && student.isGraduated()) {
                                System.out.println(" - " + student.getEmail());
                            }
                        }
                    } else {
                        System.out.println("\nInvalid input");
                    }
                    break;

                case "bf":
                    if (clearInput.size() == 3) {
                        String facultyAbbreviation = clearInput.get(1);
                        String email = clearInput.get(2);
                        for (Student student : students) {
                            if (student.getEmail().equals(email) && student.getFacultyAbbreviation().equals(facultyAbbreviation)) {
                                System.out.println(email + " belongs to faculty " + facultyAbbreviation);
                                return;
                            }
                        }
                        System.out.println("\n" + email + " does not belong to faculty " + facultyAbbreviation);
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