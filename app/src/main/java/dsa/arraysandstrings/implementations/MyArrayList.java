package dsa.arraysandstrings.implementations;

public class MyArrayList<T> {

    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(T item) {
        if (size == elements.length) {
            resize();
        }

        elements[size] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (T) elements[index];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    private void resize() {
        Object[] newElements = new Object[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    public MyArrayList<String> merge(String[] words, String[] more) {
        MyArrayList<String> sentence = new MyArrayList<>();

        for (String word : words) {
            sentence.add(word);
        }

        for (String word : more) {
            sentence.add(word);
        }

        return sentence;
    }
}