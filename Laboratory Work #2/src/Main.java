import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello Java");

        Scanner input = new Scanner(System.in);

        final File folder = new File("D:\\FAF\\Labs_OOP\\Laboratory Work 2\\working_folder");
        FileManager.listFilesForFolder(folder);
    }
}
