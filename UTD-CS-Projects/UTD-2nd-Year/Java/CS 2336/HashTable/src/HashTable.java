public class HashTable {
    private String[] table;

    public HashTable(int capacity) {
        table = new String[capacity];
    }

    private int hash(String word) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            index += (int) word.charAt(i);
        }
        return index % table.length;
    }

    public void insert(String word) {
        int index = hash(word);
        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        table[index] = word;
    }

    public boolean search(String word) {
        int index = hash(word);
        while (table[index] != null) {
            if (table[index].equals(word)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    public static void main(String[] args) {
        HashTable myTable = new HashTable(1000000);
        myTable.insert("Hello");
        myTable.insert("oHell");
        myTable.insert("World");
        System.out.println(myTable.search("Hello"));
        System.out.println(myTable.search("World!"));
    }
}
