package Classes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public abstract class File {
    public static final String repository = "D:\\FAF\\OOP\\Laboratory Work #2\\working_folder\\";
    public String fileName;
    public String extension;
    public FileTime createTime;
    public FileTime snapshot;

    public abstract void info(String filename);

    public String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    public FileTime getCreationTime(String filePath) {
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
