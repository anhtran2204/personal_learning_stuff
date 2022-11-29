package EditorEditOperations.src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Editor {
    private File file;

    public Editor(String fileName) {
        file = Paths.get(Paths.get(".").normalize().toAbsolutePath() + "/src/" + fileName).toFile();
    }

    public File getFile() {
        return this.file;
    }

    public void saveAs(String newName) {
        Path oldPath = Paths.get(this.file.getAbsolutePath());

        try {
            Files.move(oldPath, oldPath.resolveSibling(newName));
        } catch (IOException ignored) {

        }
    }

    public void insert() {

    }

//    public int delete() {
//
//    }
//
//    public int find() {
//
//    }
//
//    public int getCursor() {
//
//    }
//
//    public void moveCursor() {
//
//    }
//
//    public int replace() {
//
//    }
}
