package day11;

class Solution {
    public boolean powerOfFour(int input) {
        double d = Math.log((float)input)/Math.log(4.0);
        return d-(int)d == 0.0;
    }
}