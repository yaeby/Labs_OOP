package Classes;

import Operations.Menu;
import Operations.OperationFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class FileMonitor extends Files {
    TextFile txtFile;

    {
        txtFile = new TextFile();
    }
    ProgramFile programFile = new ProgramFile();
    OperationFile file = new OperationFile();
    ImageFile imageFile = new ImageFile();
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
        System.out.println("Created snapshot at: " + snapshot);

        assert files != null;
        for(File file: files){
            fileName = file.getName();
            FileTime lastModifiedTime = FileTime.fromMillis(file.lastModified());
            getCreateTime(repository + fileName);

            int comparisonResultMod = lastModifiedTime.compareTo(snapshot);
            int comparisonResultAdd = createTime.compareTo(snapshot);

            if (comparisonResultMod > 0 && comparisonResultAdd < 0) {
                System.out.println(fileName + " - Changed");
            }else if(comparisonResultMod < 0){
                System.out.println(fileName + " - No changed");
            }else if(comparisonResultAdd > 0){
                System.out.println(fileName + " - New file");
            }
        }

        for(String f: prevFileName){
            folder = new File(repository + f);
            if(!folder.exists())System.out.println(f + " - Delete");
        }
    }
    public void printInfo(String filename){
        extension = findExtension(filename);
        switch (extension){
            case "txt" -> {txtFile.printInfo(filename);}
            case "java", "py" -> {programFile.printInfo(filename);}
            case "png", "jpg" -> {imageFile.printInfo(filename);}
        }
    }

    @Override
    public void getCreateTime(String filePath) {
        try {
            Path file = Paths.get(filePath);
            BasicFileAttributes attr = java.nio.file.Files.readAttributes(file, BasicFileAttributes.class);
            createTime = attr.creationTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String findExtension(String fileName){

        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
    public void writeCommand(){
        Scanner inputScanner = new Scanner(System.in);

        while(true){
            String command = inputScanner.next();
            switch(command){
                case "commit" -> {commit();}
                case "info" -> {
                    String fileName = inputScanner.next();
                    printInfo(fileName);
                }
                case "status" -> {status();}
                case "help" -> {Menu.printMenu();}
                case "exit" -> {System.exit(0);}
                default -> {System.out.println("Invalid command");}
            }
        }
    }
}
