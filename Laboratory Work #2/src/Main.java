import Classes.FileMonitor;
import Classes.MonitoringChanges;
import Operations.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nLaboratory Work #2\n");
        Menu.printMenu();
        Thread thread = new Thread(new MonitoringChanges());
        thread.start();
        FileMonitor command = new FileMonitor();
        command.writeCommand();
    }
}