package dsa.arraysandstrings.implementations;

public class MyArrayListExample {
    private MyArrayListExample() {}

    public static MyArrayList<String> merge(
        String[] words,
        String[] more
    ) {
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