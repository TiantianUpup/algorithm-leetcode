# algorithm-leetcode
### Solution9
LeetCode第九题:判断一个数是否为回文数  
核心代码
```
 public static boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        Stack<Character> inputStack = new Stack<>();
        Stack<Character> outputStack = new Stack<>();
        char[] inputChar = input.toCharArray();
        int length = inputChar.length;
        for (int i = 0; i < length; i++) {
            inputStack.push(inputChar[i]);
            outputStack.push(inputChar[length - i - 1]);
        }

        return outputStack.equals(inputStack) ? true : false;
    }
```
用集合也可以实现
