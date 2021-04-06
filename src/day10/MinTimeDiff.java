package day10;

import java.util.ArrayList;
import java.util.List;

public class MinTimeDiff {

    public static void main(String[] args) {
        ArrayList<String> times = new ArrayList<>();
        times.add("00:03");
        times.add("23:59");
        times.add("12:03");
        times.add("12:01");
        times.add("12:05");
        System.out.println(timeDifference(times));
    }

    public static int timeDifference(List<String> input) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i + 1; j < input.size(); j++) {
                int d = getDifference(input.get(i), input.get(j));
                if (d < min) {
                    min = d;
                }
            }
        }
        return min;
    }

    public static int timeDifference2(List<String> input) {
        int MAX = 24 * 60;
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i + 1; j < input.size(); j++) {
                int d = getDifference(input.get(i), input.get(j));
                if (d < MAX) {
                    MAX = d;
                }
            }
        }
        return MAX;
    }

    static int getDifference(String first, String second) {
        return Math.abs(getMinutes(first) - getMinutes(second));
    }

    static int getMinutes(String time) {
        int h;
        String[] t = time.split(":");
        if (t[0].equals("00")) {
            h = 24;
        } else {
            h = Integer.parseInt(t[0]);
        }
        int m = Integer.parseInt(t[1]);
        return Math.abs(h * 60 + m);
    }

}
