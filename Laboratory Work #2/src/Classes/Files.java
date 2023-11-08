package Classes;

import java.nio.file.attribute.FileTime;

public abstract class Files {
    public String fileName;
    public String extension;
    public FileTime createTime;
    public FileTime snapshot;
    public abstract void info(String filename);
    public abstract void getCreationTime(String filePath);
}
