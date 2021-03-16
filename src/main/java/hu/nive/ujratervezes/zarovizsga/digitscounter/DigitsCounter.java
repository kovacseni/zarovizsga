package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.ArrayList;
import java.util.List;

public class DigitsCounter {

    public int getCountOfDigits(String str) {
        if (str == null) {
            return 0;
        }
        char[] charsOfStr = str.toCharArray();
        String digits = "0123456789";

        return getCount(charsOfStr, digits);
    }

    private int getCount(char[] charsOfStr, String digits) {
        List<Character> result = new ArrayList<>();

        for (char c : charsOfStr) {
            if (digits.indexOf(c) >= 0 && !result.contains(c)) {
                result.add(c);
            }
        }
        return result.size();
    }
}
