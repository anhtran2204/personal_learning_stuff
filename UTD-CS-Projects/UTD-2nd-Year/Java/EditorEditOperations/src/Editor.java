package EditorEditOperations.src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Editor {
    private File file;
    private String[] texts;
    private int[] cursor;

    public Editor(String fileName) {
        cursor = new int[2];
        try {
            Path path = Paths.get(new File(".").getCanonicalPath() + "/" + fileName);
            file = path.toFile();
            int lines = (int) Files.lines(path).count();
            texts = new String[lines];

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String text;
            int i = 0;
            while ((text = reader.readLine()) != null) {
                texts[i] = text;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return this.file;
    }

    public void saveAs(String newName) {
        try {
            this.file = new File(newName);
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
//            Scanner input = new Scanner(this.file);
//            FileWriter fileWriter = new FileWriter(rename);
//            String s = "";
//            while (input.hasNextLine()) {
//                s += input.nextLine() + "\n";
//            }
//            fileWriter.write(s);
//            fileWriter.flush();
//            fileWriter.close();
//        Path oldPath = Paths.get(this.file.getAbsolutePath());
//
//        try {
//            Files.move(oldPath, oldPath.resolveSibling(newName));
//        } catch (IOException ignored) {
//
//        }
    }

    public void insert(String name) {
        String line = texts[cursor[0]];
        String[] words = line.split(" ");
        String temp;
        if (cursor[1] < words.length) {
            temp = words[cursor[1]];
            words[cursor[1]] = name + temp;
        } else {
            temp = words[words.length - 1];
            words[words.length - 1] = name + temp;
        }

        String s = "";
        for (int i = 0; i < words.length; i++) {
            s += words[i] + " ";
        }
        texts[cursor[0]] = s;
        cursor[1] = name.length();
    }

    public void delete(int deleteLength) {
        String line = texts[cursor[0]];
        String s = line.substring(0, cursor[1]) + line.substring(cursor[1] + deleteLength);
        texts[cursor[0]] = s;
    }

    public void find(String name) {
        String[][] grid = new String[texts.length][];
        for (int i = 0; i < texts.length; i++) {
            grid[i] = texts[i].split(" ");
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals(name)) {
                    cursor[0] = i;
                    cursor[1] = j;
                }
            }
        }
    }

    public String getText(int line) {
        return texts[line];
    }

    public String getText(int row, int col) {
        String[] words = texts[row].split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i == col) {
                return words[i];
            }
        }
        return " ";
    }

    public String getText(int row, int col, int length) {
        String[] words = texts[row].split(" ");
        String s = "";
        for (int i = col; i < length; i++) {
            s += words[i];
        }
        return s;
    }

    public int[] getCursor() {
        return this.cursor;
    }

    public void moveCursor(int row, int col) {
        cursor[0] = row;
        cursor[1] = col;
    }

    public void replace(int length, String newWord) {
        String s = texts[cursor[0]];
        texts[cursor[0]] = s.substring(0, cursor[1]) + newWord + s.substring(cursor[1] + length);
    }

    public void save() {
        String s = "";
        for (int i = 0; i < texts.length; i++) {
            s += texts[i] + "\n";
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.file));
            writer.write(s);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
