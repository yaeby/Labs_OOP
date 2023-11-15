package Operations;

import Classes.Files;

import java.io.IOException;
import java.nio.file.*;

public class ChangingOperations implements Runnable {

    public final int time = 5000;
    private void checkChanges() throws IOException, InterruptedException {
        String path = Files.path;
        Path repository = Paths.get(path);

        //Watch Service
        WatchService watchService = FileSystems.getDefault().newWatchService();
        repository.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        WatchKey key = watchService.take();

        for (WatchEvent<?> event : key.pollEvents()) {
            WatchEvent.Kind<?> kind = event.kind();
            Path pathFileName = (Path) event.context();

            if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {System.out.println(pathFileName.getFileName() + " has been changed");
            } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {System.out.println(pathFileName.getFileName() + " has been deleted");
            } if (kind == StandardWatchEventKinds.ENTRY_CREATE) {System.out.println(pathFileName.getFileName() + " has been added");
            }
        }
        key.reset();
    }

    @Override
    public void run() {
        while (true) {
            try {
                checkChanges();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
