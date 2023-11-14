import Operations.Command;
import Operations.ChangingOperations;
import Operations.Menu;

public class Main {
    public static void main(String[] args) {
        //Title
        System.out.println("\nLaboratory Work #2\n");

        //Print menu
        Menu.printMenu();

        //Start Thread
        Thread thread = new Thread(new ChangingOperations());
        thread.start();

        //Read & Execute commands
        Command command = new Command();
        command.inputCommand();
    }
}