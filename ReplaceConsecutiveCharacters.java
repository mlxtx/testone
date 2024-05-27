package test;

import java.util.Stack;

public class ReplaceConsecutiveCharacters {

    public static String replaceConsecutiveChars(String s) {
        boolean changed;
        
        do {
            changed = false;
            StringBuilder result = new StringBuilder();
            Stack<CharacterCount> stack = new Stack<>();
            
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek().character == c) {
                    stack.peek().count++;
                } else {
                    if (!stack.isEmpty() && stack.peek().count >= 3) {
                        result.append(getPreviousChar(stack.peek().character));
                        changed = true;
                        stack.pop();
                    }
                    stack.push(new CharacterCount(c, 1));
                }
            }
            
            // Handle the remaining characters in the stack
            while (!stack.isEmpty()) {
                if (stack.peek().count >= 3) {
                    result.append(getPreviousChar(stack.peek().character));
                    changed = true;
                } else {
                    for (int i = 0; i < stack.peek().count; i++) {
                        result.append(stack.peek().character);
                    }
                }
                stack.pop();
            }
            
            s = result.toString();
        } while (changed);
        
        return s;
    }
    
    private static char getPreviousChar(char c) {
        return (char)(c - 1);
    }
    
    private static class CharacterCount {
        char character;
        int count;
        
        CharacterCount(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
    
    public static void main(String[] args) {
        String input = "abcccbad";
        String result = replaceConsecutiveChars(input);
        System.out.println(result);
        
        input = "aaabbbccc";
        result = replaceConsecutiveChars(input);
        System.out.println(result);
        
        input = "aabbbacd";
        result = replaceConsecutiveChars(input);
        System.out.println(result);
        
        input = "aabbbaccc";
        result = replaceConsecutiveChars(input);
        System.out.println(result);
    }
}