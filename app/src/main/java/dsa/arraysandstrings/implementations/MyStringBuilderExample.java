package dsa.arraysandstrings.implementations;

public class MyStringBuilderExample {

    private MyStringBuilderExample() {
    }

    public static String joinWithJavaStringBuilder(String[] words) {
        StringBuilder sentence = new StringBuilder();

        for (String word : words) {
            sentence.append(word);
        }

        return sentence.toString();
    }

    public static String joinWithMyStringBuilder(String[] words) {
        MyStringBuilder sentence = new MyStringBuilder();

        for (String word : words) {
            sentence.append(word);
        }

        return sentence.toString();
    }
}