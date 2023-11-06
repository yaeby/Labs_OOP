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
    public void Info(String filename) {
        String repository = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";
        File f = new File(repository + filename);
        if(f.exists()) {
            List<Integer> countInfo = new ArrayList<>();
            fileName = filename;
            extension = findExtension(repository + fileName);
            if (extension.equals("java")) {
                countInfo = file.readJavaFile(repository + filename);
            } else if (extension.equals("py")) {
                countInfo = file.readPythonFile(repository + filename);
            }
            lineCount = countInfo.get(0);
            classCount = countInfo.get(1);
            methodCount = countInfo.get(2);
            getCreateTime(repository + fileName);

            System.out.println("File Name: " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Created Time: " + createTime);
            System.out.println("Line Count: " + lineCount);
            System.out.println("Class Count: " + classCount);
            System.out.println("Method Count: " + methodCount);
        }else System.out.println("Invalid input");
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
}
