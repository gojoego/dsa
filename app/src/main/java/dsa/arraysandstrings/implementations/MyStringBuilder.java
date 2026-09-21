package dsa.arraysandstrings.implementations;

public class MyStringBuilder {

    private char[] characters;
    private int size;

    public MyStringBuilder() {
        characters = new char[16];
        size = 0;
    }

    public void append(String string) {
        ensureCapacity(size + string.length());

        for (int i = 0; i < string.length(); i++) {
            characters[size] = string.charAt(i);
            size++;
        }
    }

    public void append(char character) {
        ensureCapacity(size + 1);
        characters[size] = character;
        size++;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity <= characters.length) {
            return;
        }

        int newCapacity = characters.length * 2;

        while (newCapacity < requiredCapacity) {
            newCapacity *= 2;
        }

        char[] newCharacters = new char[newCapacity];

        for (int i = 0; i < size; i++) {
            newCharacters[i] = characters[i];
        }

        characters = newCharacters;
    }

    @Override
    public String toString() {
        return new String(characters, 0, size);
    }
}