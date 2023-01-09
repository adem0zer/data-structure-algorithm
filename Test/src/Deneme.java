import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Deneme {
    public static void main(String[] args) {
        String val = "AA";
        Map<Integer, String> bc = removedLetter("BC");
        System.out.println("to262 " + to262(val, bc));
        System.out.println("getAlpha2 " + getAlpha2(to262(val,bc),bc));
        System.out.println("getAlpha2 " + getAlpha(to26(val) + 1));
        System.out.println((char) 90);

        for (Map.Entry<Integer, String> integerStringEntry : bc.entrySet()) {
            System.out.println(integerStringEntry.getKey() + " " + integerStringEntry.getValue());
        }
    }

    public static long to26(String str) {
        long response = 0;
        for (int i = 0; i < str.length(); i++) {
            int v = (int) str.charAt(str.length() - i - 1) - 64;
            response += Math.pow(26, i) * v;
        }

        return response;
    }

    public static long to262(String str, Map<Integer, String> removedLetter) {
        long response = 0;
        for (int i = 0; i < str.length(); i++) {
            int v = getKeyOfAlphabet("" + str.charAt(str.length() - i - 1), removedLetter);
            response += Math.pow(removedLetter.size(), i) * v;
        }

        return response;
    }

    public static String getAlpha(long num) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            num--; // 1 => a, not 0 => a
            long remainder = num % 26;
            char digit = (char) (remainder + 65);
            result.insert(0, digit);
            num = ((num - remainder) / 26);
            i++;
        }
        return result.toString();
    }

    public static String getAlpha2(long num, Map<Integer, String> removedLetter) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            num--; // 1 => a, not 0 => a
            long remainder =  (num % removedLetter.size());
            String digit = getValueOfAlphabet((int)(remainder+1),removedLetter);
            result.insert(0, digit);
            num = ((num - (remainder)) / removedLetter.size());
            i++;
        }
        return result.toString();
    }

    public static Map<Integer, String> initialAlphabet() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        List<String> alphabet = new ArrayList<>();
        for (int i = 1; i <= 26 - 1; i++) {


        }
        return null;
    }

    public static List<String> getAlphabet() {
        List<String> alphabet = new ArrayList<>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 65; i <= 90; i++) {
            alphabet.add("" + (char) i);
            map.put(i - 65, "" + (char) i);
        }
        return alphabet;
    }

    public static Map<Integer, String> removedLetter(String letter) {
        List<String> alphabet = new ArrayList<>(getAlphabet());
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (char c : letter.toCharArray()) {
            alphabet.remove("" + c);
        }

        int i = 1;
        for (String s : alphabet) {
            map.put(i, s);
            i++;
        }

        return map;
    }

    public static int getKeyOfAlphabet(String letter, Map<Integer, String> removedLetter) {
        Optional<Integer> first = removedLetter.entrySet()
                .stream()
                .filter(entry -> letter.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        return first.get();
    }

    public static String getValueOfAlphabet(int letter, Map<Integer, String> removedLetter) {
        return removedLetter.get(letter);
    }

}
