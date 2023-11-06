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
    public void printInfo(String filename) {
        String repository = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";
        File f = new File(repository + filename);
        if(f.exists()){
            List<Integer> countInfo;
            countInfo = file.readTxtFile(repository + filename);
            wordCount = countInfo.get(0);
            charCount = countInfo.get(1);
            lineCount = countInfo.get(2);
            fileName = filename;
            getCreateTime(repository + fileName);
            System.out.println("File Name: " + fileName);
            System.out.println("Extension: txt");
            System.out.println("Created Time: " + createTime);
            System.out.println("Line Count: " + lineCount);
            System.out.println("Word Count: " + wordCount);
            System.out.println("Character Count: " + charCount);
        }else System.out.println("Such file does not exist or has not been deleted!!!");
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
}
