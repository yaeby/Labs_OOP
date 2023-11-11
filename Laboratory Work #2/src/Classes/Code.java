package Classes;

import Operations.GeneralOperations;

import java.util.ArrayList;
import java.util.List;

public class Code extends File {
    public int lineCount;
    public int classCount;
    public int methodCount;
    GeneralOperations file = new GeneralOperations();
    @Override
    public void info(String filename) {
        java.io.File f = new java.io.File(repository + filename);

        if(f.exists()) {
            List<Integer> countInfo = new ArrayList<>();
            fileName = filename;
            extension = getExtension(repository + fileName);

            if (extension.equals("py")) {
                countInfo = file.readPython(repository + filename);
            }
            else {
                System.out.println("Unable to read " + fileName);
            }

            lineCount = countInfo.get(0);
            classCount = countInfo.get(1);
            methodCount = countInfo.get(2);
            createTime = getCreationTime(repository + fileName);
            System.out.println("Name: " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Created time: " + createTime);
            System.out.println("Line count: " + lineCount);
            System.out.println("Class count: " + classCount);
            System.out.println("Method count: " + methodCount);
        }else System.out.println("Invalid input");
    }
}
