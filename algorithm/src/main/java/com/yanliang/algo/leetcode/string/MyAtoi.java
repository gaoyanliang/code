package com.yanliang.algo.leetcode.string;

/**
 * 8. 字符串转换整数 (atoi) https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * <p>请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * <p>函数 myAtoi(string s) 的算法如下：
 *
 * <p>读入字符串并丢弃无用的前导空格 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" ->
 * 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1]
 * ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。 返回整数作为最终结果。 注意：
 *
 * <p>本题中的空白字符只包括空格字符 ' ' 。 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yanliang
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("    -42"));
        System.out.println(myAtoi("+-42"));
    }

    public static int myAtoi(String s) {
        // 如果为空直接返回 0
        if (s == null || s.equals("")) return 0;

        // 去除前导 0
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // flag == true --> +
        boolean flag = true;
        if (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '+') {
                i++;
            } else if (ch == '-') {
                flag = false;
                i++;
            }
        }

        // 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        long num = 0; // 注意： 这里用 long 类型
        while (i < s.length() && isNum(s.charAt(i))) {

            num = num * 10 + s.charAt(i) - '0';
            if (flag && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (!flag && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        if (!flag) num = -num;

        return (int) num;
    }

    public static boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
