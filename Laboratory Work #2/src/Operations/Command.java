package Operations;

import Classes.Code;
import Classes.Files;
import Classes.Image;
import Classes.Text;

import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;
public class Command extends Files {
    public static final String path = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";
    public void inputCommand(){
        Scanner inputScanner = new Scanner(System.in);

        while(true){
            String command = inputScanner.next();
            switch(command){
                case "commit" -> {commit();}
                case "info" -> {
                    String fileName = inputScanner.next();
                    info(fileName);
                }
                case "status" -> {status();}
                case "help" -> {Menu.printMenu();}
                case "exit" -> {System.exit(0);}
                default -> {System.out.println("Invalid command");}
            }
        }
    }

    GeneralOperations file = new GeneralOperations();
    Text txtFile = new Text();
    Image imageFile = new Image();
    Code codeFile = new Code();

    public void commit() {
        FileTime currentFileTime = FileTime.from(Instant.now());

        file.writeSnapshotAndFilesName(currentFileTime, path);
    }

    public void status() {
        java.io.File folder = new java.io.File(path);
        java.io.File[] files = folder.listFiles();
        snapshot = file.readSnapshot();
        List<String> prevFileName = file.processFilesList();
        System.out.println("Last commit: " + snapshot);

        assert files != null;
        for (java.io.File file : files) {
            fileName = file.getName();
            FileTime lastModifiedTime = FileTime.fromMillis(file.lastModified());
            createTime = getCreationTime(path + fileName);

            int comparisonResultMod = lastModifiedTime.compareTo(snapshot);
            int comparisonResultAdd = createTime.compareTo(snapshot);

            if (comparisonResultMod > 0 && comparisonResultAdd < 0) {
                System.out.println(fileName + " - Changed");
            } else if (comparisonResultMod < 0) {
                System.out.println(fileName + " - No changes");
            } else if (comparisonResultAdd > 0) {
                System.out.println(fileName + " - New file");
            }
        }

        for (String f : prevFileName) {
            folder = new java.io.File(path + f);
            if (!folder.exists()) System.out.println(f + " - Deleted");
        }
    }

    public void info(String filename) {
        String extension = filename.substring(filename.lastIndexOf('.') + 1);
        switch (extension) {
            case "txt" -> {
                txtFile.info(filename);
            }
            case "py" -> {
                codeFile.info(filename);
            }
            case "png", "jpg" -> {
                imageFile.info(filename);
            }
        }
    }
}
