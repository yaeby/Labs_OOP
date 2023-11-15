package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Code extends Files {
    public int lineCount;
    public int classCount;
    public int methodCount;

    @Override
    public void info(String filename) {
        java.io.File f = new java.io.File(path + filename);
        if(f.exists()) {
            List<Integer> countInfo;
            countInfo = readPython(path + filename);
            lineCount = countInfo.get(0);
            classCount = countInfo.get(1);
            methodCount = countInfo.get(2);
            fileName = getFileName(filename);
            extension = getExtension(path + filename);
            createTime = getCreationTime(path + filename);
            System.out.println("Name: " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Created time: " + createTime);
            System.out.println("Line count: " + lineCount);
            System.out.println("Class count: " + classCount);
            System.out.println("Method count: " + methodCount);
        }else System.out.println("Invalid File Name: " + filename);
    }

    private List<Integer> readPython(String path) {
        int classCount = 0;
        int methodCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("class ")) {
                    classCount++;
                } else if (line.matches("\\s*def\\s+\\w+\\s*\\([^)]*\\):")) {
                    methodCount++;
                }
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        countInfo.add(lineCount);
        countInfo.add(classCount);
        countInfo.add(methodCount);
        return countInfo;
    }
}
