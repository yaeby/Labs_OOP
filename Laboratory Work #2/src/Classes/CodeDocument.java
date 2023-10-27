package Classes;

public class CodeDocument extends Document {
    private final int lineCount;
    private final int classCount;
    private final int methodCount;

    public CodeDocument(String name, int lineCount, int classCount, int methodCount) {
        super(name);
        this.lineCount = lineCount;
        this.classCount = classCount;
        this.methodCount = methodCount;
    }

    @Override
    public void printInfo() {
        System.out.println("Program File: " + getName());
        System.out.println("Line Count: " + lineCount);
        System.out.println("Class Count: " + classCount);
        System.out.println("Method Count: " + methodCount);
    }
}
