import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Radix {
    public static void main(String[] args) {
        String removedLetter = "";
        /*
        for (int i = 0; i < 100; i++) {
            String decode = decodeRadix26(i, removedLetter);
            long encode = encodeRadix26(decode, removedLetter);
            System.out.println("Decode Value : " + decode + " Encode Value : " + encode);
        }*/
        for (int i = 0; i < 500; i++) {
            String decode = decodeRadix36(i, removedLetter);
            long encode = encodeRadix36(decode, removedLetter);
            System.out.println("Decode Value : " + decode + " Encode Value : " + encode);
        }
    }

    public static long encodeRadix26(String str, String removedLetter) {
        return encode(str, removedLetter, 26);
    }

    public static long encodeRadix36(String str, String removedLetter) {
        return encode(str, removedLetter, 36);
    }

    public static String decodeRadix26(long num, String removedLetter) {
        return decode(num, removedLetter, 26);
    }

    public static String decodeRadix36(long num, String removedLetter) {
        return decode(num, removedLetter, 36);
    }

    private static long encode(String str, String removedLetter, int radix) {
        Map<Integer, String> dynamicVal = removedLetter(removedLetter, radix);
        long response = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = getKey("" + str.charAt(str.length() - i - 1), dynamicVal);
            response += Math.pow(dynamicVal.size(), i) * val;
        }

        return response;
    }

    private static String decode(long num, String removedLetter, int radix) {
        Map<Integer, String> dynamicVal = removedLetter(removedLetter, radix);
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            long remainder = (num % dynamicVal.size());
            String digit = getValue((int) (remainder), dynamicVal);
            result.insert(0, digit);
            num = ((num - remainder) / dynamicVal.size());
            if (num == 0) return result.toString();
        }
        if (num == 0) return getValue(0, dynamicVal);
        return result.toString();
    }

    private static Map<Integer, String> removedLetter(String letter, int radix) {
        List<String> alphabet;
        if (radix == 26) {
            alphabet = new ArrayList<>(initialAlphabet());
        } else if (radix == 36) {
            alphabet = new ArrayList<>(initialDigitAndAlphabet());
        } else {
            throw new IllegalArgumentException("Unsupported Radix format");
        }
        Map<Integer, String> map = new HashMap<>();
        for (char c : letter.toCharArray()) {
            alphabet.remove("" + c);
        }
        int i = 0;
        for (String s : alphabet) {
            map.put(i, s);
            i++;
        }

        return map;
    }

    private static List<String> initialDigitAndAlphabet() {
        List<String> digitAndAlphabet = new ArrayList<>();
        digitAndAlphabet.addAll(initialDigit());
        digitAndAlphabet.addAll(initialAlphabet());
        return digitAndAlphabet;
    }

    private static List<String> initialAlphabet() {
        List<String> alphabet = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {
            alphabet.add("" + (char) i);
        }
        return alphabet;
    }

    private static List<String> initialDigit() {
        List<String> digit = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digit.add("" + i);
        }
        return digit;
    }

    private static int getKey(String letter, Map<Integer, String> removedLetter) {
        return removedLetter.entrySet()
                .stream()
                .filter(entry -> letter.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
    }

    private static String getValue(int letter, Map<Integer, String> removedLetter) {
        return removedLetter.get(letter);
    }
}
