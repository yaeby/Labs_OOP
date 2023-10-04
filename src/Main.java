import Operations.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        FileManager.readData();
        Scanner scanner = new Scanner(System.in);
        String input = null;

        while (!Objects.equals(input, "q")) {
            Menu.printMenu();
            input = scanner.nextLine();
            switch (input) {
                case "g":
                    new GeneralOperations(scanner);
                    break;
                case "f":
                    new FacultyOperations(scanner);
                    break;
                case "s":
                    new StudentOperations(scanner);
                    break;
                case "q":
                    scanner.close();
                    break;
                default:
                    System.out.println("\t\nInvalid input");
                    break;
            }
        }
    }
}