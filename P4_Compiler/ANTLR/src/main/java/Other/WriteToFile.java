package Other;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile{
    static File file;
    static FileWriter writer;

    //fileName needs to include path
    public static void Initiate(String fileName) {
        try {
            file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                //writer = new FileWriter(fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred while trying to initiate file.");
            e.printStackTrace();
        }
    }

    public static void Emit(String text) {
        try {
            writer = new FileWriter(file.getAbsolutePath(), true);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("An I/O error occurred while trying to write to file.");
            e.printStackTrace();
        }
    }

    /*
    public static void Close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("An I/O error occurred while trying to close file.");
            e.printStackTrace();
        }
    }
    */
}
