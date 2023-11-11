package Classes;

import Operations.GeneralOperations;

import java.util.List;

public class Text extends File {
    public int lineCount;
    public int wordCount;
    public int charCount;
    GeneralOperations file = new GeneralOperations();

    @Override
    public void info(String filename) {
        java.io.File f = new java.io.File(repository + filename);
        if(f.exists()){
            List<Integer> countInfo;
            countInfo = file.readText(repository + filename);
            wordCount = countInfo.get(0);
            charCount = countInfo.get(1);
            lineCount = countInfo.get(2);
            fileName = filename;
            extension = getExtension(repository + fileName);
            createTime = getCreationTime(repository + fileName);
            getCreationTime(repository + fileName);
            System.out.println("Name: " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Created time: " + createTime);
            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + charCount);
        }else System.out.println("Invalid input");
    }
}
