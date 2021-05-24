package strings;

import java.util.Collection;
import java.util.HashMap;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(zigzagConversion("REDBLUEBLACK", 1));
    }

    static String zigzagConversion(final String s, final int rows) {

        HashMap<Integer, StringBuilder> map = new HashMap<>();

        boolean up = false;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!up) {
                if (map.containsKey(row)) {
                    map.put(row, map.getOrDefault(row, new StringBuilder().append(c)).append(c));
                } else {
                    map.put(row, new StringBuilder().append(c));
                }
                if (row + 1 == rows) {
                    up = true;
                    row--;
                } else {
                    row++;
                }
            } else {
                map.put(row, map.get(row).append(c));
                if (row == 0) {
                    up = false;
                    row++;
                } else {
                    row--;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        Collection<StringBuilder> words = map.values();
        for (StringBuilder ss : words) {
            res.append(ss);
        }
        return res.toString(); // YPEWILONLK
    }
}
