package Classes;

import Operations.GeneralOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class Text extends Files {
    public int lineCount;
    public int wordCount;
    public int charCount;
    GeneralOperations file = new GeneralOperations();

    @Override
    public void info(String filename) {
        String repository = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";
        File f = new File(repository + filename);
        if(f.exists()){
            List<Integer> countInfo;
            countInfo = file.readText(repository + filename);
            wordCount = countInfo.get(0);
            charCount = countInfo.get(1);
            lineCount = countInfo.get(2);
            fileName = filename;
            getCreationTime(repository + fileName);
            System.out.println("Name: " + fileName);
            System.out.println("Extension: txt");
            System.out.println("Created time: " + createTime);
            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + charCount);
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
}
