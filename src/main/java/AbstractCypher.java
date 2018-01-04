import org.apache.commons.lang3.StringUtils;

import java.util.*;

public abstract class AbstractCypher {

    protected static int [] fillCharsIndexes(String key) {
        int [] keys = new int[key.length()];
        char [] sortedArray = key.toCharArray();

        Arrays.sort(sortedArray);
        Map<Character, Integer> map = charactersHeatMap(sortedArray);
        Set<Character> cash = new HashSet<>();

        int combo = 1;

        for (int i = 0; i < sortedArray.length; i++) {
            Character currentChar = sortedArray[i];

            if (i != 0 && currentChar != sortedArray[i - 1]){
                combo = 1;
            }

            if (map.get(currentChar) > 1 && cash.contains(currentChar)) {
                combo ++;
            } else {
                cash.add(currentChar);
            }

            int index = StringUtils.ordinalIndexOf(key, currentChar.toString(), combo);
            keys[index] = (char) (i + 1);
        }

        return keys;
    }

    protected static Map<Character, Integer> charactersHeatMap(char[] sortedArray) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : sortedArray) {
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        return map;
    }

    protected int [][] buildMatrix(String message, String key) {
        int height = calcHeight(message, key);

        return new int[height][key.length()];
    }

    protected int calcHeight(String message, String key) {
        return message.length() % key.length() == 0 ?
                    message.length() / key.length() + 1 : message.length() / key.length() + 2;
    }


    protected int [][] createAndFillFirstRow(String message, String key) {
        int [][] matrix = buildMatrix(message, key);
        int[] chars = fillCharsIndexes(key);
        System.arraycopy(chars, 0, matrix[0], 0, chars.length);

        System.out.println("Order:");
        System.out.println(Arrays.toString(chars));
        System.out.println();

        return matrix;
    }

}
