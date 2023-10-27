package Classes;

public class ImageDocument extends Document {
    private int width;
    private int height;

    public ImageDocument(String name, int width, int height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public void printInfo() {
        System.out.println("Image File: " + getName());
        System.out.println("Image Size: " + width + "x" + height);
    }
}
