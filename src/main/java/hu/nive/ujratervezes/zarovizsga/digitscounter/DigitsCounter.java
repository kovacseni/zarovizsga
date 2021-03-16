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
        List<Character> result = new ArrayList<>();

        for (char c : charsOfStr) {
            if (digits.indexOf(c) >= 0 && result.indexOf(c) < 0) {
                result.add(c);
            }
        }
        return result.size();
    }
}
