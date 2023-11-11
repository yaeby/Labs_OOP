package Classes;

import Operations.GeneralOperations;

import java.util.List;

public class Image extends File {
    public int width;
    public int height;
    GeneralOperations file = new GeneralOperations();
    @Override
    public void info(String filename) {
        java.io.File f = new java.io.File(repository + filename);
        if(f.exists()) {
            List<Integer> countInfo;
            countInfo = file.readImage(repository + filename);
            width = countInfo.get(0);
            height = countInfo.get(1);
            fileName = filename;
            extension = getExtension(repository + fileName);
            createTime = getCreationTime(repository + fileName);
            System.out.println("Name: " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Created time: " + createTime);
            System.out.println("Width: " + width);
            System.out.println("Height: " + height);
        }else System.out.println("Invalid input");
    }
}
