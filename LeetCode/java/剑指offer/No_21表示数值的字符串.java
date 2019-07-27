package 剑指offer;

/**
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 */
public class No_21表示数值的字符串 {

    private static int index = 0;

    public static boolean isNumberic ( char[] str ) {
        if (str == null) return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }
        return flag && index == str.length;
    }


    //开头是否为正负符号
    private static boolean scanInteger ( char[] str ) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);


    }

    private static boolean scanUnsignedInteger ( char[] str ) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }


}

