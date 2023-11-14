package Operations;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GeneralOperations {
    public static final String path = "D:\\FAF\\OOP\\Laboratory Work #2\\src\\snapshot_time.txt";
    public void writeSnapshotAndFilesName(FileTime snapshot, String pathRepository) {

        File folder = new File(pathRepository);
        File[] files = folder.listFiles();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(snapshot + "\n");
            assert files != null;
            for(File file: files){
                writer.write(file.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileTime readSnapshot() {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            String line = read.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
            Instant instant = Instant.from(formatter.parse(line));

            return FileTime.from(instant);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle error appropriately
        }
    }

    public List<String> processFilesList() {
        List<String> listFileName = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            read.readLine();

            String line;
            while ((line = read.readLine()) != null) {
                listFileName.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFileName;
    }

    public List<Integer> readText(String path){
        int wordCount = 0;
        int charCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countInfo.add(wordCount);
        countInfo.add(charCount);
        countInfo.add(lineCount);
        return countInfo;
    }

    public List<Integer> readPython(String path) {
        int classCount = 0;
        int methodCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("class ")) {
                    classCount++;
                } else if (line.matches("\\s*def\\s+\\w+\\s*\\([^)]*\\):")) {
                    methodCount++;
                }
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        countInfo.add(lineCount);
        countInfo.add(classCount);
        countInfo.add(methodCount);
        return countInfo;
    }

    public List<Integer> readImage(String path){
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
