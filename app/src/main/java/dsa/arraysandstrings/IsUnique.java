package dsa.arraysandstrings;

public class IsUnique {
    
    private IsUnique() {}

    public static boolean isUniqueBruteForce(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }                
            }
        }
        return true;
    }
}