package EditorEditOperations.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Editor {
    private File file;

    public Editor(String fileName) {
        try {
            file = Paths.get(new File(".").getCanonicalPath() + "/" + fileName).toFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return this.file;
    }

    public void saveAs(String newName) {
        File rename = new File(newName);
        try {
            Scanner input = new Scanner(this.file);
            FileWriter fileWriter = new FileWriter(rename);
            String s = "";
            while (input.hasNextLine()) {
                s += input.nextLine() + "\n";
            }
            fileWriter.write(s);
            fileWriter.flush();
            fileWriter.close();
            file = rename;
            System.out.println(this.file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Path oldPath = Paths.get(this.file.getAbsolutePath());
//
//        try {
//            Files.move(oldPath, oldPath.resolveSibling(newName));
//        } catch (IOException ignored) {
//
//        }
    }

    public void insert(String name) {

    }

    public void delete(int wordIndex) {

    }

    public int find(String name) {
        return 0;
    }

    public String getText(int line) {
        return "";
    }

    public String getText(int row, int col) {
        return "";
    }

    public String getText(int row, int col, int length) {
        return "";
    }

    public int[] getCursor() {
        return new int[2];
    }

    public void moveCursor(int row, int col) {

    }

    public void replace(int length, String newWord) {

    }

    public void save() {

    }
}
