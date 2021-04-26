package Other;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile implements IWriteToFile {
    File file;
    FileWriter writer;

    @Override
    //fileName needs to include path
    public void Initiate(String fileName) {
        try {
            file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                writer = new FileWriter(fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred while trying to initiate file.");
            e.printStackTrace();
        }
    }

    @Override
    public void Emit(String text) {
        try {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("An I/O error occurred while trying to write to file.");
            e.printStackTrace();
        }
    }

    @Override
    public void Close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("An I/O error occurred while trying to close file.");
            e.printStackTrace();
        }
    }
}
