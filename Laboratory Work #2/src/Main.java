import Classes.FileMonitor;
import Classes.MonitoringChanges;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MonitoringChanges());
        thread.start();
        FileMonitor command = new FileMonitor();
        command.writeCommand();
    }
}