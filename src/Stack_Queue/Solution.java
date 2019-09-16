package Stack_Queue;
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

 */

import java.util.Stack;

public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                // 如果栈顶没有任何元素被推入，则返回false
                if (stack.isEmpty())
                        return false;

                // 取出栈顶元素
                char top_c = stack.pop();

                if (top_c == '(' && c != ')')
                    return false;
                if (top_c == '[' && c != ']')
                    return false;
                if (top_c == '{' && c != '}')
                    return false;


            }
        }
        // 如果都有效匹配，或者传入字符串为空，则返回true
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println((new Solution().isValid("[]")));
    }
}
