import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {

    /**
     -     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations in any order.
     -     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     -     * You can ignore "1" in the string.
     -     * 2 - abc, 3 - def
     -     * 4 - ghi, 5 - jkl, 6 - mno
     -     * 7 - pqrs, 8 - tuv, 9 - wxyz
     -     * Solve this using both iterative and recursive approach.
     -     * Input: digits = "23"
     -     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     -     * @param args - String array as input
     -     */
    public static void main(String[] args) {
        String input = "234";
        System.out.println("Iterative approach: ".concat(Arrays.toString(getLetterComboIterative(input))));
    }

    public static String[] getLetterComboIterative(String input) {
        if (input.length() == 0) return new String[]{};
        String[] letterMapper = new String[]{"0","0","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        result.add(""); //first iteration will have empty string to match
        for (int i = 0; i < input.length(); i++) {
            result = combination(letterMapper[Character.getNumericValue(input.charAt(i))], result);
        }
        return result.toArray(new String[0]);
    }

    public static List<String> combination(String letters, List<String> result) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < letters.length(); i++) {
            for (String c : result) {
                temp.add(c + letters.charAt(i));
            }
        }
        return temp;
    }

}
