package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Text extends Files {
    public int lineCount;
    public int wordCount;
    public int charCount;

    @Override
    public void info(String filename) {
        java.io.File f = new java.io.File(path + filename);
        if(f.exists()){
            List<Integer> countInfo;
            countInfo = readText(path + filename);
            wordCount = countInfo.get(0);
            charCount = countInfo.get(1);
            lineCount = countInfo.get(2);
            fileName = getFileName(filename);
            extension = getExtension(path + filename);
            createTime = getCreationTime(path + filename);
            System.out.println("Name: " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Created time: " + createTime);
            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + charCount);
        }else System.out.println("Invalid File Name: " + filename);
    }

    private List<Integer> readText(String path){
        int wordCount = 0;
        int charCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countInfo.add(wordCount);
        countInfo.add(charCount);
        countInfo.add(lineCount);
        return countInfo;
    }
}
