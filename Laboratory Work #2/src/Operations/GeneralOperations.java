package Operations;

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
            for (File file : files) {
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
}
