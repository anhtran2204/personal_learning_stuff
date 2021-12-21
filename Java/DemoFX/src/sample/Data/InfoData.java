package sample.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

public class InfoData {
    private static InfoData instance = new InfoData();
    private static String filename= "Infos.txt";

    private ObservableList<Info> infos;
    private DateTimeFormatter formatter;

    public InfoData() {
        formatter= DateTimeFormatter.ofPattern("MM-dd-yyyy");
    }

    public ObservableList<Info> getInfos() {
        return infos;
    }

    public void loadInfos() throws Exception {
        infos = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] infoPieces = input.split("\t");

                String name = infoPieces[0];
                String age = infoPieces[1];
                String height = infoPieces[2];

                Info.
            }
        }
    }
}
