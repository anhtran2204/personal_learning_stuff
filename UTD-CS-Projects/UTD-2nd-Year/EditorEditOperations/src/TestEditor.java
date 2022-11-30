package EditorEditOperations.src;

public class TestEditor {
    public static void main(String[] args) {
        String[] AntiHeros = {
                "Samuel L. Jackson and John Travolta in Pulp Fiction (1994)",
                "Brad Pitt in Fight Club (1999)",
                "Robert De Niro in Taxi Driver (1976)"
        };

        String[] Jokers = {
                "Heath Ledger in The Dark Knight (2008)",
                "Joaquin Phoenix in Joker (2019)",
                "Jack Nicholson in Batman (1989)"
        };

        // Open a file AntiHeros.txt
        Editor editor = new Editor("AntiHeros.txt");
        // Save as Jokers.txt.  current file should be Jokers.txt
        System.out.println(editor.getFile().getAbsolutePath());
        editor.saveAs("Jokers.txt");
        // insert row 0 col 0
        editor.insert("Joker");
        // assert that row 0 col 0 is Joker
        assert(editor.getText(0).equals("JokerAnti Hero Actors ranked"));
        editor.delete(9);
        assert (editor.getText(0).equals("Joker Actors ranked"));

        // find "Samuel"
        editor.find("Samuel");
        int[] rowcol = editor.getCursor();
        assert(rowcol[0] == 1 && rowcol[1] == 3);
        // assert that row 1 col 3 is Samuel
        assert(editor.getText(rowcol[0], rowcol[1], 6).equals("Samuel"));

        // replace AntiHeros[0] with Jokers[0]
        editor.moveCursor(1, 3);
        editor.replace(AntiHeros[0].length(), Jokers[0]);
        assert (editor.getText(1, 3).equals(Jokers[0]));

        editor.moveCursor(2, 3);
        editor.replace(AntiHeros[1].length(), Jokers[1]);
        assert (editor.getText(2, 3).equals(Jokers[1]));

        editor.moveCursor(3, 3);
        editor.replace(AntiHeros[2].length(), Jokers[2]);
        assert (editor.getText(3, 3).equals(Jokers[2]));

        editor.save();
    }
}
