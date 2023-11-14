package Classes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Image extends Files {
    public int width;
    public int height;

    @Override
    public void info(String filename) {
        java.io.File f = new java.io.File(path + filename);
        if(f.exists()) {
            List<Integer> countInfo;
            countInfo = readImage(path + filename);
            width = countInfo.get(0);
            height = countInfo.get(1);
            fileName = filename;
            extension = getExtension(path + fileName);
            createTime = getCreationTime(path + fileName);
            System.out.println("Name: " + fileName);
            System.out.println("Extension: " + extension);
            System.out.println("Created time: " + createTime);
            System.out.println("Width: " + width);
            System.out.println("Height: " + height);
        }else System.out.println("Invalid input");
    }

    private List<Integer> readImage(String path){
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedImage image = ImageIO.read(new File(path));
            if (image != null) {
                countInfo.add(image.getWidth());
                countInfo.add(image.getHeight());
            } else {
                System.out.println("Invalid type of image");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countInfo;
    }
}
