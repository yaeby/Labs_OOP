package Operations;

import Classes.Faculty;
import Classes.Student;
import Classes.StudyField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    //READER
    private static final List<Student> students = Student.getStudentsList();

    public static void readData() {
        List<String> facultiesData = loadFacultyData();
        List<String> studentData = loadStudentData();
        List<String> graduatesData = loadGraduateData();

        for (String facultyInfo : facultiesData) {
            String[] parts = facultyInfo.split("/");
            if (parts.length == 4) {
                String facultyName = parts[1];
                String facultyAbbreviation = parts[2];
                StudyField studyField = StudyField.valueOf(parts[3]);
                Faculty faculty = new Faculty(facultyName, facultyAbbreviation, studyField);
                Faculty.addFaculty(faculty);
            }
        }

        for (String studentInfo : studentData) {
            String[] parts = studentInfo.split("/");
            if (parts.length == 8) {
                String facultyAbbreviation = parts[1];
                String studentFirstName = parts[2];
                String studentLastName = parts[3];
                String email = parts[4];
                int birthDay = Integer.parseInt(parts[5]);
                int birthMonth = Integer.parseInt(parts[6]);
                int birthYear = Integer.parseInt(parts[7]);
                Student student = new Student(studentFirstName, studentLastName, email, birthDay, birthMonth, birthYear, facultyAbbreviation);
                students.add(student);
            }
        }

        for (String graduateInfo : graduatesData) {
            String[] parts = graduateInfo.split("/");
            if (parts.length == 2) {
                String email = parts[1];
                for (Student student : students) {
                    if (student.getEmail().equals(email)) {
                        student.graduate();
                        break;
                    }
                }
            }
        }
    }

    //WRITER
    private static final String Path = "../StudentManagementSystem/txtFiles/";
    private static final String studentPath = Path + "Students.txt";
    private static final String facultyPath = Path + "Faculties.txt";
    private static final String graduatesPath = Path + "GraduatedStudents.txt";

    public static void writeData(String input) {
        input += "\n";
        if (input.startsWith("ns/")) {
            saveDataToFile(input, studentPath);
        } else if (input.startsWith("nf/")) {
            saveDataToFile(input, facultyPath);
        } else if (input.startsWith("gs/")) {
            saveDataToFile(input, graduatesPath);
        }
    }

    private static List<String> loadData(String fileName) {
        List<String> data = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            data.addAll(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<String> loadStudentData() {
        return loadData(studentPath);
    }

    public static List<String> loadFacultyData() {
        return loadData(facultyPath);
    }

    public static List<String> loadGraduateData() {
        return loadData(graduatesPath);
    }

    private static void saveDataToFile(String data, String fileName) {
        try {
            Files.createDirectories(Paths.get(Path));
            Files.write(Paths.get(fileName), data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
