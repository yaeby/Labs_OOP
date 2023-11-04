import Classes.FileMonitor;
import Classes.MonitoringChanges;
import Operations.Menu;

public class Main {
    public static void main(String[] args) {
        //Title
        System.out.println("\nLaboratory Work #2\n");

        //Print menu
        Menu.printMenu();

        //Start Thread
        Thread thread = new Thread(new MonitoringChanges());
        thread.start();

        //Read/Execute commands
        FileMonitor command = new FileMonitor();
        command.writeCommand();
    }
}