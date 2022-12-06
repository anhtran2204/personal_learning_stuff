package Demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        FileWriter writer = new FileWriter(file);

        writer.write("Joker");
        writer.append("Hello World!\n");
        writer.append("My name is Anh Tran.\n");
        writer.append("I'm 20 years old.");

        writer.flush();
        writer.close();
    }
}
