package MyString.src;

public class MyString {
    private char chars[];

    public MyString(char input[]) {
        chars = input.clone();
    }

    public MyString(String s) {
        chars = s.toCharArray();
    }

    public MyString(MyString s) {
        chars = s.chars.clone();
    }

    public char[] toCharArray() {
        return chars.clone();
    }

    public String toString() {
        return new String(chars);
    }

    //CODE ALL NEW METHODS HERE!
    MyString(char[] value, int offset, int count) {
        chars = new char[count];
        System.arraycopy(value, offset, chars, chars[0], count);
    }

    MyString(StringBuffer buffer) {
        buffer.trimToSize();
        chars = new char[buffer.length()];
        for (int i = 0; i < buffer.length(); i++) {
            chars[i] = buffer.charAt(i);
        }
    }

    MyString(StringBuilder builder) {
        builder.trimToSize();
        chars = new char[builder.length()];
        for (int i = 0; i < builder.length(); i++) {
            chars[i] = builder.charAt(i);
        }
    }

    char charAt(int index) {
        return chars[index];
    }

    int compareTo(MyString anotherString) {
        for (int i = 0; i < Math.min(this.chars.length, anotherString.length()); i++) {
            if (this.chars[i] - anotherString.charAt(i) != 0) {
                return this.chars[i] - anotherString.charAt(i);
            }
        }
        return this.chars.length - anotherString.length();
    }

    MyString concat(MyString str) {
        char[] temp = this.chars.clone();
        this.chars = new char[chars.length + str.length()];
        System.arraycopy(temp, 0, this.chars, 0, temp.length);
        System.arraycopy(str.chars, 0, this.chars, temp.length, str.chars.length);
        return new MyString(temp);
    }

    boolean endsWith(MyString suffix) {
        int index = suffix.chars.length - 1;
        boolean flag = false;
        for (int i = this.chars.length - 1; i >= index; i--) {
            if (index == 0) {
                flag = true;
                break;
            }
            if (this.chars[i] == suffix.chars[index]) {
                index--;
            } else {
                index = suffix.chars.length - 1;
            }
        }
        return flag;
    }

    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject == null) {
            return false;
        }
        if (getClass() != anObject.getClass()) {
            return false;
        }

        MyString check = (MyString) anObject;
        int length = Math.max(this.chars.length, check.chars.length);
        for (int i = 0; i < length; i++) {
            if (i >= this.chars.length) {
                return false;
            }
            if (this.chars[i] != check.chars[i]) {
                return false;
            }
        }
        return true;
    }

    boolean equalsIgnoreCase(MyString anotherString) {
        if (this.chars.length != anotherString.chars.length) {
            return false;
        }
        for (int i = 0; i < this.chars.length; i++) {
            boolean check = this.chars[i] == anotherString.chars[i] + 32 || this.chars[i] + 32 == anotherString.chars[i]
                    || this.chars[i] == anotherString.chars[i];
            if (!check) {
                return false;
            }
        }
        return true;
    }

    int indexOf(int ch) {
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    int indexOf(int ch, int fromIndex) {
        for (int i = 0; i < this.chars.length; i++) {
            if ((this.chars[i] == ch) && (i >= fromIndex)) {
                return i;
            }
        }
        return -1;
    }

    int indexOf(MyString str) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if (count == str.chars.length) {
                index = i - count;
                break;
            }
            if (this.chars[i] == str.chars[count]) {
                count++;
            } else {
                count = 0;
            }
        }
        return index;
    }

    int indexOf(MyString str, int fromIndex) {
        int count = 0;
        int index = -1;
        int j = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if ((this.chars[i] == str.chars[j]) && (i >= fromIndex)) {
                count++;
                if (count == 1) {
                    index = i;
                }
                j++;
            } else {
                count = 0;
                j = 0;
            }
        }
        return index;
    }

    int lastIndexOf(int ch) {
        int index = -1;
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] == ch) {
                index = i;
            }
        }
        return index;
    }

    int lastIndexOf(int ch, int fromIndex) {
        int index = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if ((this.chars[i] == ch) && (i <= fromIndex)) {
                index = i;
            }
        }
        return index;
    }

    int lastIndexOf(MyString str) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if (count == str.chars.length) {
                index = i - count;
                count = 0;
            }
            if (this.chars[i] == str.chars[count]) {
                count++;
            } else {
                count = 0;
            }
        }
        return index;
    }

    int lastIndexOf(MyString str, int fromIndex) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if (count == str.chars.length) {
                index = i - count;
                count = 0;
            }
            if ((this.chars[i] == str.chars[count]) && (i <= fromIndex)) {
                count++;
            } else {
                count = 0;
            }
        }
        return index;
    }

    int length() {
        return chars.length;
    }

    MyString replace(char oldChar, char newChar) {
        char[] newChars = new char[this.chars.length];

        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] == oldChar) {
                newChars[i] = newChar;
            } else {
                newChars[i] = this.chars[i];
            }
        }
        return new MyString(newChars);
    }

    //bit different from String - we will keep it simple with one char as seperator
    MyString[] split(char ch) {
        int occurrence = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] == ch) {
                occurrence++;
            }
        }

        MyString[] newStrings = new MyString[occurrence + 1];
        int pos = 0;
        int index = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] == ch) {
                char[] newChars = new char[i - pos];
                System.arraycopy(this.chars, pos, newChars, 0, i - pos);
                newStrings[index] = new MyString(newChars);
                pos = i + 1;
                index++;
            }
            if (i == this.chars.length - 1) {
                char[] newChars = new char[i - pos + 1];
                System.arraycopy(this.chars, pos, newChars, 0, i - pos + 1);
                newStrings[index] = new MyString(newChars);
            }
        }
        return newStrings;
    }

    boolean startsWith(MyString prefix) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < prefix.chars.length; i++) {
            if (index == prefix.chars.length - 1) {
                flag = true;
                break;
            }
            if (this.chars[i] == prefix.chars[index]) {
                index++;
            } else {
                index = 0;
            }
        }
        return flag;
    }

    MyString substring(int beginIndex) {
        char[] newChars = new char[this.chars.length - beginIndex];
        int index = 0;
        for (int i = beginIndex; i < this.chars.length; i++) {
            newChars[index] = this.chars[i];
            index++;
        }
        return new MyString(newChars);
    }

    MyString substring(int beginIndex, int endIndex) {
        char[] newChars = new char[endIndex - beginIndex];
        int index = 0;
        for (int i = beginIndex; i < endIndex; i++) {
            newChars[index] = this.chars[i];
            index++;
        }
        return new MyString(newChars);
    }

    MyString toLowerCase() {
        char[] newChars = new char[this.chars.length];
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] >= 65 && this.chars[i] <= 90) {
                newChars[i] = (char) (this.chars[i] + 32);
            } else {
                newChars[i] = this.chars[i];
            }
        }
        return new MyString(newChars);
    }

    MyString toUpperCase() {
        char[] newChars = new char[this.chars.length];
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] >= 97 && this.chars[i] <= 122) {
                newChars[i] = (char) (this.chars[i] - 32);
            } else {
                newChars[i] = this.chars[i];
            }
        }
        return new MyString(newChars);
    }

    MyString trim() {
        int start = 0;
        int end = this.chars.length - 1;

        while (Character.isSpaceChar(this.chars[start]) && Character.isSpaceChar(this.chars[end])) {
            start++;
            end--;
        }

        char[] newChars = new char[end + 1 - start];
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = this.chars[start + i];
        }

        return new MyString(newChars);
    }

    public static void main(String[] args) {
        String s = "Welcome to Java!";
        String s2 = "Java welcomes you!";
        MyString ms = new MyString(s);
        MyString ms2 = new MyString("Welcome to Java!");
        MyString ms3 = new MyString("Java welcomes you!");

        MyString ms5 = new MyString("Java ");

        MyString ms8 = new MyString("welcome to java!");
        MyString ms8p = new MyString("Welcome to Python!");
    }
}