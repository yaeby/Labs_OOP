package Classes;

import java.nio.file.attribute.FileTime;

public abstract class Files {
    public String fileName;
    public String extension;
    public FileTime createTime;
    public FileTime snapshot;
    public abstract void Info(String filename);
    public abstract void getCreateTime(String filePath);
}
