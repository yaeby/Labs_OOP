package Classes;

public class TextDocument extends Document {
    private final int lineCount;
    private final int wordCount;
    private final int charCount;

    public TextDocument(String name, int lineCount, int wordCount, int charCount) {
        super(name);
        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.charCount = charCount;
    }

    @Override
    public void printInfo() {
        System.out.println("Text File: " + getName());
        System.out.println("Line Count: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
    }
}
