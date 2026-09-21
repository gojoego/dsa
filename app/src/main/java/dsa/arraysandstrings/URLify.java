package dsa.arraysandstrings;

import dsa.arraysandstrings.implementations.MyStringBuilder;

class URLify {
    private URLify() {}

    // time O(n), space O(n)
    public static String urlifyBackward(String s, int trueLength) {
        // convert String to char[]
        char[] sArray = s.toCharArray();
        int spaceCount = 0;

        for (int i = 0; i < trueLength; i++) {
            if (sArray[i] == ' ') {
                spaceCount++;
            } 
        }

        int writeIndex = trueLength + (spaceCount * 2) - 1;

        for (int readIndex = trueLength - 1; readIndex >= 0; readIndex--) {
            if (sArray[readIndex] == ' ') {
                sArray[writeIndex] = '0';
                writeIndex--;
                sArray[writeIndex] = '2';
                writeIndex--;
                sArray[writeIndex] = '%'; 
                writeIndex--;
            } else {
                sArray[writeIndex] = sArray[readIndex];
                writeIndex--;
            }
        }

        return new String(sArray);
    }

    // time O(n), space O(n)
    public static String urlifyStringBuilder(String s) {
        // convert string to char array
        char[] sArray = s.toCharArray(); 

        // utilize StringBuilder implementation
        MyStringBuilder output = new MyStringBuilder();

        // iterate 
        for (int i = 0; i < sArray.length; i++) {
            // if " " replace with %20  
            if (sArray[i] == ' ') {
                output.append("%20");
            } else {
                output.append(sArray[i]);
            }
        }
        
        // return converted String 
        return output.toString();
    }

    // time O(n), space O(1)
    public static void replaceStrings(char[] str, int trueLength) {
        int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        // add null for extra spaces
        if (newIndex + 1 < str.length) str[newIndex + 1] = '\0';

        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
            if (str[oldIndex] == ' ') {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex--;
            }
        }
    }

    // time O(n), space O(1)
    public static int countOfChar(
        char[] str, 
        int start, 
        int end, 
        int target
    ) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) {
                count++;   
            }
        }
        return count;
    }

    // time O(n), space O(n)
    public static String urlify(String input, int trueLength) {
        char[] characters = input.toCharArray();
        replaceStrings(characters, trueLength);
        return new String(characters);
    }
}