package day11;

import java.util.HashMap;
import java.util.Map;

public class Validsuduko {

    public static void main(String[] args) {

        int[][] suduko = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println(validateSuduko(suduko));
    }


    public static boolean validateSuduko(int[][] s) {

        Map<Integer, Integer> m = new HashMap<>();

        // validate complete row
        for (int[] row : s) {
            for (int j = 0; j < s.length; j++) {
                int num = row[j];
                if (num == 0)
                    continue;
                if (m.get(num) != null) {
                    return false;
                } else {
                    m.put(num, 1);
                }
            }
            m.clear();
        }

        for (int i = 0; i < s.length; i += 3) {
            for (int j = i; j < 3 + i; j++) {
                for (int k = i; k < 3 + i; k++) {
                    int num = s[j][k];
                    if (num == 0)
                        continue;
                    if (m.get(num) != null) {
                        return false;
                    } else {
                        m.put(num, 1);
                    }
                }
            }
            m.clear();
        }
        return true;
    }

}
