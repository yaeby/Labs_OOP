package Classes;

public abstract class Document {
    private final String name;
    private final long lastModifiedTime;

    public Document(String name) {
        this.name = name;
        lastModifiedTime = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public boolean hasChanged(long snapshotTime) {
        return lastModifiedTime > snapshotTime;
    }

    public abstract void printInfo();
}