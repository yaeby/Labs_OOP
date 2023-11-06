package Operations;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralOperations {
    public void writeSnapshotAndFilesName(FileTime snapshot, String pathRepository) {

        File folder = new File(pathRepository);
        File[] files = folder.listFiles();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\FAF\\OOP\\Laboratory Work #2\\src\\snapshot_time.txt"))) {
            writer.write(snapshot + "\n");
            for(File file: files){
                writer.write(file.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileTime readSnapshot() {
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\FAF\\OOP\\Laboratory Work #2\\src\\snapshot_time.txt"))) {
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
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\FAF\\OOP\\Laboratory Work #2\\src\\snapshot_time.txt"))) {
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

    public List<Integer> readTxtFile(String path){
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
    public List<Integer> readJavaFile(String path) {
        int classCount = 0;
        int methodCount = 0;
        int lineCount = 0;
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            Pattern classPattern = Pattern.compile("\\b(class|interface|enum)\\s+\\w+\\s*\\{");
            Pattern methodPattern = Pattern.compile("\\b\\w+(?:<[^>]+>)?\\s+\\w+\\s*\\([^)]*\\)\\s*(?:throws\\s+\\w+(?:,\\s*\\w+)*)?\\s*\\{");
            while ((line = reader.readLine()) != null) {
                Matcher classMatcher = classPattern.matcher(line);
                Matcher methodMatcher = methodPattern.matcher(line);
                if (classMatcher.find()) {
                    classCount++;
                }
                else if (methodMatcher.find()) {
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
    public List<Integer> readPythonFile(String path) {
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

    public List<Integer> readImageFile(String path){
        List<Integer> countInfo = new ArrayList<>();
        try {
            BufferedImage image = ImageIO.read(new File(path));
            if (image != null) {
                countInfo.add(image.getWidth());
                countInfo.add(image.getHeight());
            } else {
                System.out.println("The image could not be read.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countInfo;
    }
}
