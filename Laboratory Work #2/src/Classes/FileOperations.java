package Classes;

import Operations.GeneralOperations;
import Operations.Menu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class FileOperations extends Files {

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
                case "help" -> {
                    Menu.printMenu();}
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

        String repository = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";

        file.writeSnapshotAndFilesName(currentFileTime, repository);
    }

    public void status() {
        String repository = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";
        File folder = new File(repository);
        File[] files = folder.listFiles();
        snapshot = file.readSnapshot();
        List<String> prevFileName = file.processFilesList();
        System.out.println("Last commit: " + snapshot);

        assert files != null;
        for (File file : files) {
            fileName = file.getName();
            FileTime lastModifiedTime = FileTime.fromMillis(file.lastModified());
            getCreationTime(repository + fileName);

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
            folder = new File(repository + f);
            if (!folder.exists()) System.out.println(f + " - Deleted");
        }
    }

    public void info(String filename) {
        extension = getExtension(filename);
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

    @Override
    public void getCreationTime(String filePath) {
        try {
            Path file = Paths.get(filePath);
            BasicFileAttributes attr = java.nio.file.Files.readAttributes(file, BasicFileAttributes.class);
            createTime = attr.creationTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getExtension(String fileName) {

        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}