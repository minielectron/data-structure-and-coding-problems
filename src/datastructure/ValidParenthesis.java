package datastructure;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis v = new ValidParenthesis();
        System.out.println(v.isValid(")"));
    }

    public boolean isValid(String s) {

        Stack<Character> characters = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    characters.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (characters.isEmpty()) return false;
                    characters.pop();
                    break;
                default:
                    throw new IllegalArgumentException("The input is not valid");

            }
        }

        return characters.isEmpty();
    }
}
