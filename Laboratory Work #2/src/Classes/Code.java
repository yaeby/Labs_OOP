package Classes;

import Operations.GeneralOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Code extends Files {
    public int lineCount;
    public int classCount;
    public int methodCount;
    GeneralOperations file = new GeneralOperations();
    @Override
    public void info(String filename) {

        String repository = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";
        File f = new File(repository + filename);

        if(f.exists()) {
            List<Integer> countInfo = new ArrayList<>();
            fileName = filename;
            extension = findExtension(repository + fileName);

            if (extension.equals("py")) {
                countInfo = file.readPython(repository + filename);
            }
            else {
                System.out.println("Unable to read " + fileName);
            }

            lineCount = countInfo.get(0);
            classCount = countInfo.get(1);
            methodCount = countInfo.get(2);
            getCreationTime(repository + fileName);

            System.out.println("Name: " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Created time: " + createTime);
            System.out.println("Line count: " + lineCount);
            System.out.println("Class count: " + classCount);
            System.out.println("Method count: " + methodCount);
        }else System.out.println("Invalid input");
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
    private String findExtension(String fileName){

        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
