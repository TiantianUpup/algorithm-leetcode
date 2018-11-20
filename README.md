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
用集合也可以实现 . 
=============================后续更新==================================
将int转化为String，可以不使用栈这个数据结构

### Solution13
LeetCode第十三题:计算罗马数字的值  
核心代码
```
    /**
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * */
    public static int romanToInt(String s) {
        //计算的值
        int sum = 0;
        //存储罗马数字的值
        Map<Character, Integer> romanNumber = getRomanMap();
        Stack<Character> inputStack = new Stack<>();

        //用于处理特殊的罗马计算使用
        //Stack<Character> specialStack = new Stack<>();
        char[] input = s.toCharArray();
        int length = input.length;
        for (int i = 0; i < length; i++) {
            inputStack.push(input[length - i -1]);
        }


        while (inputStack.size() > 0) {
            Character temp = inputStack.pop();
            if (temp != 'I' && temp != 'X' && temp != 'C') {
                sum += romanNumber.get(temp);
            } else {
                if (inputStack.size() > 0) {
                    //I的情况下
                    if (temp.equals('I')) {
                        if (inputStack.peek().equals('V') || inputStack.peek().equals('X')) {
                            sum += romanNumber.get(inputStack.peek());
                            sum -= romanNumber.get(temp);
                            //移除
                            inputStack.pop();
                        } else {
                            sum += romanNumber.get(temp);
                        }
                    }

                    //X的情况下
                    if (temp.equals('X')) {
                        if (inputStack.peek().equals('L') || inputStack.peek().equals('C')) {
                            sum += romanNumber.get(inputStack.peek());
                            sum -= romanNumber.get(temp);
                            //移除
                            inputStack.pop();
                        } else {
                            sum += romanNumber.get(temp);
                        }
                    }

                    //C的情况下
                    if (temp.equals('C')) {
                        if (inputStack.peek().equals('D') || inputStack.peek().equals('M')) {
                            sum += romanNumber.get(inputStack.peek());
                            sum -= romanNumber.get(temp);
                            //移除
                            inputStack.pop();
                        } else {
                            sum += romanNumber.get(temp);
                        }
                    }
                } else {
                    sum += romanNumber.get(temp);
                }
            }
        }
        return sum;
    }
```
