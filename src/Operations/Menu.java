package Operations;

public class Menu {

    public static void printMenu() {
        System.out.println("\nWelcome to TUM's student management system!");
        System.out.println("What do you want to do?");
        System.out.println("g - General operations");
        System.out.println("f - Faculty operations");
        System.out.println("s - Student operations");
        System.out.println();
        System.out.println("q - Quit program");
        System.out.println();
        System.out.print("Your input: ");
    }

    public static void printGeneralOperations() {
        System.out.println("\nGeneral operations: ");
        System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
        System.out.println("ss/<student email> - search student and show faculty");
        System.out.println("df- display faculties");
        System.out.println("dl/<field> - display all faculties of a field");
        System.out.println();
        System.out.println("b - Back");
        System.out.println("q - Quit program");
        System.out.println();
        System.out.print("Your input: ");
    }

    public static void printFacultyOperations() {
        System.out.println("\nFaculty operations: ");
        System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student");
        System.out.println("gs/<email> - graduate student");
        System.out.println("ds/<faculty abbreviation> - display enrolled students");
        System.out.println("dg/<faculty abbreviation> - display graduated students");
        System.out.println("bf/<faculty abbreviation>/<email> - check if student belongs to faculty");
        System.out.println();
        System.out.println("b - Back");
        System.out.println("q - Quit Program");
        System.out.print("Your input: ");
    }

    public static void printStudentOperations() {
        System.out.println("\nStudent operations: ");
        System.out.println("fd - display full data of any student (graduate and undergraduate)");
        System.out.println("fe - display full data of enrolled students");
        System.out.println("fg - display full date of graduate student");
        System.out.println();
        System.out.println("b - Back");
        System.out.println("q - Quit Program");
        System.out.print("Your input: ");
    }
}