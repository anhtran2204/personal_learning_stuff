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
        chars = new char[count - offset];
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
        int diff = 0;
        for (int i = 0; i < Math.min(this.chars.length, anotherString.length()); i++) {
            if (this.chars[i] - anotherString.charAt(i) != 0) {
                diff = this.chars[i] - anotherString.charAt(i);
            }
        }
        if (diff == 0) {
            return this.chars.length - anotherString.length();
        }
        return diff;
    }

    MyString concat(MyString str) {
        char[] temp = new char[chars.length + str.length()];
        System.arraycopy(this.chars, 0, temp, 0, this.chars.length);
        System.arraycopy(str.chars, 0, temp, this.chars.length, str.chars.length);
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
        return this == anObject;
    }

    boolean equalsIgnoreCase(MyString anotherString) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < this.chars.length; i++) {
            if (index == anotherString.chars.length) {
                flag = true;
                break;
            }
            if (this.chars[i] == anotherString.chars[index]) {
                index++;
            } else {
                index = 0;
            }
        }
        return flag;
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
        int index = -1;
        int count = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if (count == str.chars.length) {
                index = i - count;
                break;
            }
            if ((this.chars[i] == str.chars[count]) && (i >= fromIndex)) {
                count++;
            } else {
                count = 0;
            }
        }
        return index;
    }

    int lastIndexOf(int ch) {
        int index = 0;
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
            if ((this.chars[i] == ch) && (i >= fromIndex)) {
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
            if ((this.chars[i] == str.chars[count]) && (i >= fromIndex)) {
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
        int start = 0;
        int end = 0;
        int curr = 0;

        int occurrence = 0;
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] == ch) {
                occurrence++;
            }
        }

        MyString[] newStrings = new MyString[occurrence + 1];
        int index = 0;
        while (start < this.chars.length) {
            if (this.chars[curr] == ch) {
                end = curr;
                char[] newChars = new char[end + 1 - start];
                System.arraycopy(chars, start, newChars, start, end - start);
                newStrings[index] = new MyString(newChars);
            }
            curr++;
            start = end;
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
        for (int i = beginIndex; i < this.chars.length; i++) {
            newChars[i] = this.chars[i];
        }
        return new MyString(newChars);
    }

    MyString substring(int beginIndex, int endIndex) {
        char[] newChars = new char[endIndex + 1 - beginIndex];
        for (int i = beginIndex; i <= endIndex; i++) {
            newChars[i] = this.chars[i];
        }
        return new MyString(newChars);
    }

    MyString toLowerCase() {
        char[] newChars = new char[this.chars.length];
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] >= 65 && this.chars[i] <= 90) {
                newChars[i] = (char) (this.chars[i] + 32);
            }
        }
        return new MyString(newChars);
    }

    MyString toUpperCase() {
        char[] newChars = new char[this.chars.length];
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] >= 97 && this.chars[i] <= 122) {
                newChars[i] = (char) (this.chars[i] - 32);
            }
        }
        return new MyString(newChars);
    }

    MyString trim() {
        int start = 0;
        int end = 0;
        boolean first = false;
        for (int i = 0; i < this.chars.length; i++) {
            if (!first && Character.isAlphabetic(this.chars[i])) {
                first = true;
                start = i;
            }
            if (this.chars[i] == ' ' && this.chars[i+1] == ' ') {
                end = i - 1;
            }
        }

        char[] newChars = new char[end + 1 - start];
        for (int i = start; i <= end; i++) {
            newChars[i] = this.chars[i];
        }
        return new MyString(newChars);
    }

}