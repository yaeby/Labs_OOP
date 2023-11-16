package Classes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public abstract class Files {
    public static final String path = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";
    protected String fileName;
    protected String extension;
    protected FileTime createTime;

    protected abstract void info(String filename);

    protected String getFileName(String fileName){
        return fileName.substring(0, fileName.indexOf("."));
    }
    protected String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    public static FileTime getCreationTime(String filePath) {
        try {
            Path file = Paths.get(filePath);
            BasicFileAttributes attr = java.nio.file.Files.readAttributes(file, BasicFileAttributes.class);
            return attr.creationTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
