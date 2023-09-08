package Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StorageUtil {
    public static final int STARTING_CASH = 1000;
    private static final String fileName = "msa_storage.txt";
    private static final String filePath = System.getProperty("user.home") + "/" + fileName;

    // append to file

//    public static void writeToFile(String data) {
//
//        Path path = Paths.get(filePath);
//
//        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.US_ASCII, StandardOpenOption.CREATE,
//                StandardOpenOption.APPEND)) {
//            writer.write(data + "\n");
//        } catch (IOException x) {
//            System.err.format("IOException: %s%n", x);
//        }
//
//    }


    public static void overwriteFileLines(String[] data){
        Path path = Paths.get(filePath);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.US_ASCII)) {
            if(data == null)
                writer.write("");
            else {
                for (String s : data) {
                    writer.write(s + "\n");
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }

    public static boolean doesFileExist() {
        File f = new File(filePath);
        return f.exists() && !f.isDirectory();
    }


    //write
    public static List<String> readFileLines(){

        List<String> data = new ArrayList<>();
        Path file = Paths.get(filePath);

        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.US_ASCII)) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return data;
    }
}

